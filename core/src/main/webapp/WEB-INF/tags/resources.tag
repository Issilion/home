<%@tag import="java.util.Set"%>
<%@tag import="java.util.Collections"%>
<%@tag import="org.springframework.web.context.support.ServletContextResource" trimDirectiveWhitespaces="true"%>
<%@tag import="java.util.TreeSet"%>
<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="type" required="true" type="String" %>
<%@ attribute name="path" required="true" type="String" %>
<%
if (!path.startsWith("/")) {
    path = "/" + path;
}

StringBuilder sb = new StringBuilder();
Set<String> pathes;

if (application.getResourceAsStream(path) == null) {
    pathes = new TreeSet<String>(application.getResourcePaths("/resources" + path));
} else {
    pathes = Collections.singleton(path);
}

if ("css".equals(type)) {
    for (String p : pathes) {
        %><link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %><%= p %>?t=<%= new ServletContextResource(application, p).lastModified() %>" media="all"/><%
    }
} else if ("js".equals(type)) {
    for (String p : pathes) {
        %><script type="text/javascript" src="<%= application.getContextPath() %><%= p %>?t=<%= new ServletContextResource(application, p).lastModified() %>"></script><%
    }
} else if ("plain".equals(type)) {
    for (String p : pathes) {
        %><%= application.getContextPath() %><%= p %>?t=<%= new ServletContextResource(application, p).lastModified() %><%
    }
}

%>