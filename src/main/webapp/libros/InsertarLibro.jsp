<%@ page import="com.joseoliveros.libros.model.Libro" %>
<%--
  Created by IntelliJ IDEA.
  User: joliveros
  Date: 28/12/2016
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String isbn = request.getParameter("isbn");
    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");

    Libro libro = new Libro(isbn, titulo, categoria);
    libro.insertar();
    
    response.sendRedirect("MostrarLibros.jsp");
%>
<html>
<head>
    <title>Formulario Insertar Libro</title>
</head>
<body>

</body>
</html>
