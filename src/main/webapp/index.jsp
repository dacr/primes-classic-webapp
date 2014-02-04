<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="dummy.MetaInfo" %>
<%!
  // Of course this is not thread safe and not very good from performance point of view
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:MM:ss.SSS");
%>
<html>
<head>
</head>
<body>
  <h1> <%=sdf.format(new Date()) %>  </h1>
<ul>
  <li>Project <%=MetaInfo.project()%> release <%=MetaInfo.version()%></li>
  <li>This page is a JSP, but a
     <a href="${pageContext.request.contextPath}/servlet/">servlet mapping</a>
      is also available.
  </li>
</ul>

</body>
</html>
