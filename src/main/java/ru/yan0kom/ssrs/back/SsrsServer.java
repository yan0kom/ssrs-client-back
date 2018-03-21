package ru.yan0kom.ssrs.back;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.asyncclient.AsyncHTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;

import com.microsoft.sqlserver.ReportExecution2005.ArrayOfParameterValue;
import com.microsoft.sqlserver.ReportExecution2005.ExecutionHeader;
import com.microsoft.sqlserver.ReportExecution2005.LoadReport;
import com.microsoft.sqlserver.ReportExecution2005.LoadReportResponse;
import com.microsoft.sqlserver.ReportExecution2005.ParameterValue;
import com.microsoft.sqlserver.ReportExecution2005.Render;
import com.microsoft.sqlserver.ReportExecution2005.RenderResponse;
import com.microsoft.sqlserver.ReportExecution2005.ReportExecutionService;
import com.microsoft.sqlserver.ReportExecution2005.ReportExecutionServiceSoap;
import com.microsoft.sqlserver.ReportExecution2005.SetExecutionParameters;
import com.microsoft.sqlserver.ReportExecution2005.SetExecutionParametersResponse;
import com.microsoft.sqlserver.ReportService2010.GetItemDefinition;
import com.microsoft.sqlserver.ReportService2010.ReportingService2010;
import com.microsoft.sqlserver.ReportService2010.ReportingService2010Soap;

import ru.yan0kom.ssrs.back.dis.DeviceInformationSettings;

public class SsrsServer {
	private String name;
	private String location;
	private String user;
	private String domain;
	private String password;

	private ReportExecutionServiceSoap executionService;
	private ReportingService2010Soap manageService;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LoadReportResponse loadReport(String path) {
		LoadReport lr = new LoadReport();
		lr.setReport(path);
		return getExecutionService().loadReport(lr, null, null, null);
	}

	public String loadReportExt(String path) {
		GetItemDefinition itemDefinition = new GetItemDefinition();
		itemDefinition.setItemPath(path + ".ext");

		String emptyExt = String.format("{\"path\": \"%s\"}", path);
		try {
			return new String(getManageService().getItemDefinition(itemDefinition, null, null).getDefinition(), "UTF-8");
		} catch (SOAPFaultException e) {
			if (e.getFault().getDetail() != null && e.getFault().getDetail().hasChildNodes()
					&& "ErrorCode".equals(e.getFault().getDetail().getFirstChild().getNodeName())
					&& "rsItemNotFound".equals(e.getFault().getDetail().getFirstChild().getTextContent())) {
				// there is no path.ext on server, should return empty ext
				return emptyExt;
			}
			return e.getMessage();
		} catch (UnsupportedEncodingException e) {
			return e.getMessage();
		}
	}

	public RenderResponse renderReport(String executionId, RenderFormat format, DeviceInformationSettings deviceInfo) {
		ExecutionHeader executionHeader = new ExecutionHeader();
		executionHeader.setExecutionID(executionId);

		Render render = new Render();
		render.setFormat(format.getName());
		if (deviceInfo != null) {
			render.setDeviceInfo(deviceInfo.getXmlString());
		}

		return getExecutionService().render(render, executionHeader, null, null);
	}

	public SetExecutionParametersResponse setReportParameters(String executionId, List<ParameterValue> paramValues) {
		ExecutionHeader executionHeader = new ExecutionHeader();
		executionHeader.setExecutionID(executionId);

		SetExecutionParameters executionParameters = new SetExecutionParameters();
		ArrayOfParameterValue arrayOfParameterValue = new ArrayOfParameterValue();
		arrayOfParameterValue.getParameterValue().addAll(paramValues);
		executionParameters.setParameters(arrayOfParameterValue);
		return getExecutionService().setExecutionParameters(executionParameters, executionHeader, null, null);
	}

	public Credentials getCredentials() {
		return new NTCredentials(user, password, null, domain);
	}

	private ReportExecutionServiceSoap getExecutionService() {
		if (executionService == null) {
			ReportExecutionService service = new ReportExecutionService(getClass().getResource("/ReportExecution2005.wsdl"));
			ReportExecutionServiceSoap port = service.getReportExecutionServiceSoap();
			setupEndpoint((BindingProvider) port, location + "/ReportExecution2005.asmx");
			executionService = port;
		}
		return executionService;
	}

	private ReportingService2010Soap getManageService() {
		if (manageService == null) {
			ReportingService2010 service = new ReportingService2010(getClass().getResource("/ReportService2010.wsdl"));
			ReportingService2010Soap port = service.getReportingService2010Soap();
			setupEndpoint((BindingProvider) port, location + "/ReportService2010.asmx");
			manageService = port;
		}
		return manageService;
	}

	private void setupEndpoint(BindingProvider provider, String endpoint) {
		provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
		provider.getRequestContext().put(AsyncHTTPConduit.USE_ASYNC, Boolean.TRUE);
		provider.getRequestContext().put(Credentials.class.getName(), getCredentials());

		Client client = ClientProxy.getClient(provider);
		AsyncHTTPConduit http = (AsyncHTTPConduit) client.getConduit();

		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
		httpClientPolicy.setAutoRedirect(true);
		httpClientPolicy.setAllowChunking(false);
		http.setClient(httpClientPolicy);
	}
}
