<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.joseoliveros.libros.database.DataBaseHelper" %>
<%@ page import="javafx.scene.shape.HLineTo" %><%--
  Created by IntelliJ IDEA.
  User: joliveros
  Date: 26/12/2016
  Time: 02:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script type="text/javascript" src="../js/libros/validaciones.js"></script>
    <link rel="stylesheet" href="../css/libros/estilo.css">
    <title>Formulario Libro</title>
</head>
<%
    DataBaseHelper helper = new DataBaseHelper();
    String consultaSQL = "SELECT DISTINCT (CATEGORIA) FROM LIBROS";
    ResultSet rs = helper.seleccionarRegistros(consultaSQL);
%>
<body>
<div class="container">
    <form action="InsertarLibro.jsp" id="miformulario" onsubmit="return validacion()" method="get">
        <fieldset>
            <legend>Formulario Alta Libro</legend>
            <p>
                <label for="isbn">ISBN:</label>
                <input type="text" name="isbn" id="isbn">
            </p>
            <p>
                <label for="titulo">Título:</label>
                <input type="text" name="titulo" id="titulo">
            </p>
            <p>
                <label for="categoria">Categoría:</label>
                <select name="categoria" id="categoria">
                    <option value="seleccionar">Seleccionar</option>
                    <%
                        while (rs.next()) { %>
                    <option value="<%=rs.getString("categoria")%>"><%=rs.getString("categoria")%></option>
                      <%  }
                    %>
                </select>
            </p>
            <p>
                <input type="submit" value="Insertar">
            </p>
        </fieldset>
    </form>
</div>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>
