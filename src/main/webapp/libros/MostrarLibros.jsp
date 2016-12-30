<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: joliveros
  Date: 30/12/2016
  Time: 08:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <title>Mostrar Libros</title>
</head>
<body>
<div class="container">
    <%
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:/Users/capitanjovi/IdeaProjects/JEEPractica/src/main/webapp/WEB-INF/db/jeepractica", "jovi", "jovi");
            statement = connection.createStatement();
            String query = "SELECT isbn, titulo, categoria FROM libros";
            rs = statement.executeQuery(query);

            while (rs.next()) { %>
    <%=rs.getString("isbn")%>
    <%=rs.getString("titulo")%>
    <%=rs.getString("categoria")%>
    <br>
    <% }
    } catch (ClassNotFoundException e) {
        System.out.println("Error en la carga del driver");
    } catch (SQLException e) {
        System.out.println("Error accediendo a la base de datos"
                + e.getMessage());
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando el resultset" + e.getMessage());
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la sentencia" + e.getMessage());
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexion" + e.getMessage());
            }
        }
    }
    %>
    <a href="FormularioInsertarLibro.jsp">
        <button>Insertar Libro</button>
    </a>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
