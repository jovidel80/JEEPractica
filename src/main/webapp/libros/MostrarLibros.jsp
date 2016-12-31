<%@ page import="java.sql.*" %>
<%@ page import="com.joseoliveros.libros.database.DataBaseHelper" %><%--
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
    <select name="categoria" id="categoria">
        <option value="seleccionar">Seleccionar</option>

        <%
            ResultSet rs = null;

            try {
                String consultaSQL = "SELECT DISTINCT(categoria) FROM LIBROS";
                DataBaseHelper helper = new DataBaseHelper();
                rs = helper.seleccionarRegistros(consultaSQL);
                while (rs.next()) { %>
        <option value="<%=rs.getString("categoria")%>"><%=rs.getString("categoria")%></option>

        <% } %>
    </select>
    <br>
    <%
        consultaSQL = "SELECT * FROM LIBROS";
        rs = helper.seleccionarRegistros(consultaSQL);
        while (rs.next()) { %>

    <%=rs.getString("isbn")%>
    <%=rs.getString("titulo")%>
    <%=rs.getString("categoria")%>
    <br>
    <%
            }
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
