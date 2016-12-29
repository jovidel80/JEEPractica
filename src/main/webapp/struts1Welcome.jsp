<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%--
  Created by IntelliJ IDEA.
  User: joliveros
  Date: 23/12/2016
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>
        Welcome <bean:write name="userForm" property="username"/>
        <%--Valor <bean:write name="userForm" property="valor"/>--%>
        <br>
        <a href="/LoginPage.do"><button>Volver</button></a>
    </h1>
</body>
</html>
