<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %><%--
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

    Connection connection = null;
    Statement statement = null;

    int filas = 0;

    try {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection(
                "jdbc:h2:C:/Users/joliveros/IdeaProjects/JEEPractica/src/main/webapp/WEB-INF/db/jeepractica",
                "jovi",
                "jovi");
        statement = connection.createStatement();
        String query = "INSERT INTO LIBROS(ISBN, TITULO, CATEGORIA) VALUES ('" + isbn + "', '" + titulo + "', '" + categoria + "')";
        filas = statement.executeUpdate(query);
//        response.sendRedirect("MostrarLibros.jsp");
    } catch (ClassNotFoundException e) {
        System.out.println("Error en la carga del driver"
                + e.getMessage());
    } catch (SQLException e) {
        System.out.println("Error accediendo a la base de datos"
                + e.getMessage());
    } finally {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la sentencia" +
                        e.getMessage());
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexion" +
                        e.getMessage());
            }
        }
    }
%>
<html>
<head>
    <title>Formulario Insertar Libro</title>
</head>
<body>

</body>
</html>
