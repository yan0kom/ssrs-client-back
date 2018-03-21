package ru.yan0kom.ssrs.back;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.sqlserver.ReportExecution2005.ExecutionInfo;
import com.microsoft.sqlserver.ReportExecution2005.ParameterValue;
import com.microsoft.sqlserver.ReportExecution2005.RenderResponse;

import ru.yan0kom.ssrs.back.dis.DeviceInformationSettings;
import ru.yan0kom.ssrs.back.dis.HtmlDis;
import ru.yan0kom.ssrs.back.dis.ImageDis;
import ru.yan0kom.ssrs.back.dis.OutputFormat;
import ru.yan0kom.ssrs.back.dis.XmlDis;

/**
 * Servlet implementation class ExecutionService
 * wrapper for SSRS ReportExecution2005 service
 */
public class ExecutionService extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	private static final Pattern reportLinkPattern = Pattern.compile("href\\=\"replink\\=([^?]+)\\?([^&]+)([^\"]+)\"");
	
    public ExecutionService() {
        super();
		//Bus bus = BusFactory.getDefaultBus();
		//bus.setProperty(AsyncHTTPConduit.USE_ASYNC, Boolean.TRUE);        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		if ("/load".equals(action)) {
			load(request, response); 
		}else if ("/render".equals(action)) {
			render(request, response); 
		}else if ("/ext".equals(action)) {
			ext(request, response); 
		}else {
			writeError(response, "GET action not found");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		if ("/parameterize".equals(action)) {
			parameterize(request, response); 
		}else {
			writeError(response, "POST action not found");
		}		
	}
	
	private void load(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getParameter("path");
			ExecutionInfo result = SsrsConfig.getInstance().getDefaultServer().loadReport(path).getExecutionInfo();
			
			response.setContentType("application/json; charset=utf-8");
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(response.getWriter(), result);			
		} catch (Exception e) {
			writeException(response, e);
		}
	}

	private void parameterize(HttpServletRequest request, HttpServletResponse response) {
		try {
			String executionId = request.getParameter("executionId");

			List<ParameterValue> pvList = new LinkedList<ParameterValue>();
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readTree(request.getReader());
			Iterator<JsonNode> params = jsonNode.get("parameters").elements();
			while (params.hasNext()) {
				JsonNode param = params.next();
				ParameterValue pv = new ParameterValue();
				pv.setName(param.get("name").asText());
				pv.setValue(param.get("value").asText());
				pvList.add(pv);
			}
						
			SsrsConfig.getInstance().getDefaultServer().setReportParameters(executionId, pvList);
			
			response.setContentType("text/plain; charset=utf-8");
		} catch (Exception e) {			
			writeException(response, e);
		}
	}
	
	/** Renders report to specified format
	 *<p> Request parameters:
	 *<br> report - path to report on SSRS server
	 *<br> executionId - value returned by load, ExecutionInfo.getExecutionID()
	 *<br> attachment - put result into attachment, if filename not specified then report path ('/' replaced with "_") used
	 *<br> filename - filename for attachment
	 * */
	@SuppressWarnings("deprecation")
	private void render(HttpServletRequest request, HttpServletResponse response) {
		try {
			String report = request.getParameter("report");
			String executionId = request.getParameter("executionId");
			RenderFormat format = RenderFormat.valueOf(request.getParameter("format"));
			String attachment = request.getParameter("attachment"); //optional, set Content-Disposition
			String filename = request.getParameter("filename"); //optional
			Boolean noRepLink = Boolean.valueOf(request.getParameter("noRepLink")); //optional
			
			//this url will be appended by image id
			StringBuilder imageUrl = new StringBuilder(getServletContext().getContextPath());
			imageUrl.append("/image");
			imageUrl.append("?report=");
			imageUrl.append(report);
			imageUrl.append("&amp;format=");
			imageUrl.append(format.getName());
			imageUrl.append("&amp;session=");
			imageUrl.append(executionId);
			imageUrl.append("&amp;id=");
			
			DeviceInformationSettings deviceInfo = null;
			switch (format) {
				case ATOM:
					break;
				case CSV:
					break;
				case EXCEL:	case EXCELOPENXML:
					break;
				case HTML40: case HTML5: 
					HtmlDis html = new HtmlDis();
					html.setHtmlFragment(true);
					html.setUserAgent(request.getHeader("User-Agent"));
					html.setStreamRoot(imageUrl.toString());
					html.setReplacementRoot("replink=");
					deviceInfo = html;
					break;
				case IMAGE:
					ImageDis image = new ImageDis();
					image.setOutputFormat(OutputFormat.TIFF);
					deviceInfo = image;
					break;
				case MHTML:
					break;
				case NULL:
					break;
				case PDF:
					break;
				case PPTX:
					break;
				case RGDI:
					break;
				case RPL:				 
					break;
				case WORD: case WORDOPENXML:
					break;
				case XML:
					XmlDis xml = new XmlDis();
					xml.setIndented(true);	
					deviceInfo = xml;
					break;
			}
			
			RenderResponse result = SsrsConfig.getInstance().getDefaultServer().renderReport(executionId, format, deviceInfo);			
			response.setContentType(result.getMimeType());
			if (format == RenderFormat.HTML40 || format == RenderFormat.HTML5 || format == RenderFormat.CSV || format == RenderFormat.XML) {
				response.setCharacterEncoding(SsrsEncoding.toJava(result.getEncoding()));
			}
			if (attachment != null) {
				if (filename == null) {
					filename = report.replaceAll("/", "_");
				}
				response.addHeader("Content-Disposition", String.format("attachment; filename=%s.%s", filename, format.getExtension()));
			}
			
			if ((format == RenderFormat.HTML40 || format == RenderFormat.HTML5) && !noRepLink) {			
				int divPos = 0;
				String div = new String(result.getResult(), SsrsEncoding.toJava(result.getEncoding()));
				PrintWriter out = response.getWriter();
				Matcher m = reportLinkPattern.matcher(div);
				while (m.find()) {
					out.append(div.substring(divPos, m.start(0)));
					out.append("href=\"javascript:ReportViewer.openReportLink('");
					out.append(URLDecoder.decode(m.group(2), "UTF-8"));
					out.append("', '");
					out.append(URLDecoder.decode(m.group(3), "UTF-8").replaceAll("&amp;amp;", "&").substring(1));
					out.append("');\"");
					divPos = m.end(0);
				}
				out.append(div.substring(divPos, div.length()));
			}else {
				response.getOutputStream().write(result.getResult());
			}
			
			response.flushBuffer();
		} catch (Exception e) {			
			writeException(response, e);
		}
	}
	
	private void ext(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getParameter("path");
			String result = SsrsConfig.getInstance().getDefaultServer().loadReportExt(path);
			
			response.setContentType("application/json; charset=utf-8");			
			response.getWriter().write(result);
			response.flushBuffer();
		} catch (Exception e) {
			writeException(response, e);
		}
	}	
	
	private void writeException(HttpServletResponse response, Exception e) {
		String msg = String.format("Exception: [%s] %s", e.getClass().getName(), e.getMessage());
		try {
			response.setContentType("text/plain; charset=utf-8");
			response.getWriter().println(msg);
			e.printStackTrace(response.getWriter());
		} catch (IOException e1) {
			System.err.println(msg);
		}
	}

	private void writeError(HttpServletResponse response, String err) {
		String msg = String.format("Error: %s", err);
		try {
			response.setContentType("text/plain; charset=utf-8");
			response.getWriter().println(msg);			
		} catch (IOException e) {
			System.err.println(msg);
		}
	}	
}

