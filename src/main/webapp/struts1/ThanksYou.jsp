<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%--
  Created by IntelliJ IDEA.
  User: joliveros
  Date: 03/01/2017
  Time: 01:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<h2>Eres permitido, muy bien, no envies el rol de rata</h2>
<h2>Hola, <%=request.getParameter("username")%></h2>

<%
    if (request.getParameter("rol") != null) { %>
        <h2>Haz enviado el rol <%=request.getParameter("rol")%></h2>
  <%  } %>
<html:form action="/Login">

    <html:text property="url"></html:text>
</html:form>

</body>
</html>
