<%@ page import="ru.yan0kom.ssrs.back.SsrsConfig" %>
<%@ page import="ru.yan0kom.ssrs.back.SsrsServer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSRS client, server side</title>
</head>
<body>
	<h3>Backend for SSRS client</h3>
<%
	SsrsConfig cfg = SsrsConfig.getInstance();
	if (cfg != null) {
%>
		<p>Configuration loaded</p>
<%
		if (cfg.getServers() != null) {
%>
			<p>Configured servers:</p>
<%
			for (SsrsServer srv : cfg.getServers()) {
%>	
				<p><%=srv.getName()%>, location <%=srv.getLocation()%></p>
<%
			}
		}
	}
			
%>
</body>
</html>