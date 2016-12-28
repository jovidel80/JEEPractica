<%--
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
    <script type="text/javascript" src="js/validaciones.js"></script>
    <link rel="stylesheet" href="css/estilo.css">
    <title>Formulario Libro</title>
</head>
<body>
    <form action="">
        <fieldset>
            <legend>Formulario Alta Libro</legend>
            ISBN:
            <input type="text" name="isbn"><br>
            Título:
            <input type="text" name="titulo"><br>
            Categoría:
            <input type="text" name="categoria"><br>
            <input type="button" value="Insertar" onclick="validacion()">
        </fieldset>
    </form>
</body>
</html>
