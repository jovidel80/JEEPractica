<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.joseoliveros.libros.database.DataBaseHelper" %><%--
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

    String consultaSQL = "INSERT INTO LIBROS(ISBN, TITULO, CATEGORIA) VALUES ('" + isbn + "', '" + titulo + "', '" + categoria + "')";

    DataBaseHelper db = new DataBaseHelper();
    int filas = db.modificarRegistro(consultaSQL);
    response.sendRedirect("MostrarLibros.jsp");
%>
<html>
<head>
    <title>Formulario Insertar Libro</title>
</head>
<body>

</body>
</html>
