<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%--
  Created by IntelliJ IDEA.
  User: joliveros
  Date: 03/01/2017
  Time: 02:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<html:form action="/Login">

    <br/>
    <bean:message key="label.user.username" /> :
    <html:text property="username" size="20"/>
    <html:hidden property="url" value="<%=request.getRequestURL().toString()%>"/> <br>
    URL de la página: <%=request.getRequestURL().toString()%>
    <br/><br/>
    <html:submit>
        <bean:message key="label.user.button.submit" />
    </html:submit>

</html:form>

</body>
</html>
