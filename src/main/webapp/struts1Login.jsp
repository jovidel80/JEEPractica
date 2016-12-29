<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%--
  Created by IntelliJ IDEA.
  User: joliveros
  Date: 29/12/2016
  Time: 04:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Struts html:text example</h1>

<html:form action="/Login">
    <div style="color: red">
        <html:errors/>
    </div>
    <div style="padding: 26px">
        <div style="float:left;padding-right:8px;">
            UserName
        </div>
        <html:text property="username" size="20" maxlength="20"/>
    </div>
    <div style="padding:16px">
        <div style="float:left;padding-right:8px;">
            <html:submit>Submit</html:submit>
        </div>
        <html:reset>Reset</html:reset>
    </div>
</html:form>
</body>
</html>
