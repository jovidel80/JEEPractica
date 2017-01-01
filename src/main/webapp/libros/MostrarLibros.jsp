<%@ page import="com.joseoliveros.libros.model.Libro" %>
<%@ page import="java.util.List" %>
<%--
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
            List<String> listaCategorias = Libro.buscarTodasLasCategorias();
            for (String categoria: listaCategorias) { %>
        <option value="<%=categoria%>"><%=categoria%></option>

        <% } %>
    </select>
    <br>
    <%
        List<Libro> listaLibros = Libro.buscarTodosLosLibros();
        for (Libro libro: listaLibros) { %>
    <%=libro.getIsbn()%>
    <%=libro.getTitulo()%>
    <%=libro.getCategoria()%>
    <br>
    <% } %>
    <br>
    <a href="FormularioInsertarLibro.jsp">
        <button>Insertar Libro</button>
    </a>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
