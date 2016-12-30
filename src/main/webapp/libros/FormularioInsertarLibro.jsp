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
    <script type="text/javascript" src="../js/libros/validaciones.js"></script>
    <link rel="stylesheet" href="../css/libros/estilo.css">
    <title>Formulario Libro</title>
</head>
<body>
    <form action="InsertarLibro.jsp" id="miformulario" onsubmit="validacion()">
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
                <input type="text" name="categoria" id="categoria">
            </p>
            <p>
                <input type="submit" value="Insertar">
            </p>
        </fieldset>
    </form>
</body>
</html>
