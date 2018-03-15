package ru.yan0kom.ssrs.back;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.helpers.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Servlet implementation class ImageService
 */
public class ImageService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ImageService() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse rsResponse = null;
		try { //1.6 without try(resource) 
			StringBuilder imageUrl = new StringBuilder(SsrsConfig.getInstance().getDefaultServer().getLocation());
			imageUrl.append("?");
			imageUrl.append(request.getParameter("report"));
			imageUrl.append("&rs:SessionID=");
			imageUrl.append(request.getParameter("session"));
			imageUrl.append("&rs:Format=");
			imageUrl.append(request.getParameter("format"));
			imageUrl.append("&rs:ImageID=");
			imageUrl.append(request.getParameter("id"));
			
			
			httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(imageUrl.toString());
			
			rsResponse = httpClient.execute(httpGet, getHttpContext());
			HttpEntity httpEntity = rsResponse.getEntity();

			if (rsResponse.getStatusLine().getStatusCode() == 200) {
				response.setContentType(httpEntity.getContentType().getValue());
				IOUtils.copy(httpEntity.getContent(), response.getOutputStream());
			}else {
				response.setContentType("text/plain");
				response.getWriter().print(rsResponse.getStatusLine().getReasonPhrase());
			}
		} finally {
			if (rsResponse != null) {
				rsResponse.close();
			}
			if (httpClient != null) {
				httpClient.close();
			}
		}
	}
	
	private HttpClientContext getHttpContext() {
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(AuthScope.ANY, SsrsConfig.getInstance().getDefaultServer().getCredentials());
			
		HttpClientContext httpContext = HttpClientContext.create();
		httpContext.setCredentialsProvider(credsProvider);
		return httpContext;
	}

}
