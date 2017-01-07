<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
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
<h1>Struts 1 example</h1>

<html:form action="/Login">
    <div style="color: red">
        <html:errors/>
    </div>
    <div style="padding: 26px">
        <div style="float:left;padding-right:8px;">
            <bean:message key="label.common.name"/> <br>
            <bean:message key="label.common.password"/>
        </div>
        <html:text property="username" size="20" maxlength="20"/><br>
        <html:text property="password" size="10" maxlength="10"/>
    </div>
    <div style="padding:16px">
        <div style="float:left;padding-right:8px;">
            <html:submit><bean:message key="label.common.button.submit"/></html:submit>
        </div>
        <html:reset><bean:message key="label.common.button.reset"/></html:reset>
    </div>
</html:form>
</body>
</html>
