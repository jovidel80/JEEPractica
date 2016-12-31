package com.joseoliveros.libros.model;

import com.joseoliveros.libros.database.DataBaseHelper;

import java.sql.ResultSet;

public class Libro {

    public static ResultSet buscarTodasLasCategorias() {
        String consultaSQL = "SELECT DISTINCT(categoria) FROM LIBROS";
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet rs = helper.seleccionarRegistros(consultaSQL);
        return rs;
    }

    public static void insertar(String isbn, String titulo, String categoria) {
        String insercionSQL = "INSERT INTO LIBROS (ISBN, TITULO, CATEGORIA) VALUES ('" + isbn + "', '" + titulo + "', '" + categoria + "')";
        DataBaseHelper helper = new DataBaseHelper();
        helper.modificarRegistro(insercionSQL);
    }

    public static ResultSet buscarTodosLosLibros() {
        DataBaseHelper helper = new DataBaseHelper();
        String consultaSQL = "SELECT * FROM LIBROS";
        ResultSet rs = helper.seleccionarRegistros(consultaSQL);
        return rs;
    }
}
