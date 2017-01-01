package com.joseoliveros.libros.model;

import com.joseoliveros.libros.database.DataBaseHelper;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Libro {

    private static final Logger log = Logger.getLogger(Libro.class.getPackage().getName());

    private String isbn;
    private String titulo;
    private String categoria;

    public Libro(String isbn, String titulo, String categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static List<String> buscarTodasLasCategorias() {
        String consultaSQL = "SELECT DISTINCT(categoria) FROM LIBROS";
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet rs = helper.seleccionarRegistros(consultaSQL);
        List<String> listaCategorias = new ArrayList<>();
        try {
            while (rs.next()) {
                listaCategorias.add(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            log.debug("Error de SQL: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    log.debug("Error cerrando el ResulSet: " + e.getMessage());
                }
            } 
        }
        return listaCategorias;
    }

    public void insertar() {
        String insercionSQL = "INSERT INTO LIBROS (ISBN, TITULO, CATEGORIA) VALUES ('" + this.isbn + "', '" + this.titulo + "', '" + this.categoria + "')";
        DataBaseHelper helper = new DataBaseHelper();
        int filasAfectadas = helper.modificarRegistro(insercionSQL);
        log.debug("Filas afectadas " + filasAfectadas);
    }

    public static List<Libro> buscarTodosLosLibros() {
        DataBaseHelper helper = new DataBaseHelper();
        String consultaSQL = "SELECT * FROM LIBROS";
        ResultSet rs = helper.seleccionarRegistros(consultaSQL);
        List<Libro> listaLibros = new ArrayList<>();
        try {
            while (rs.next()) {
                listaLibros.add(new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("categoria")));
            }
        } catch (SQLException e) {
            log.debug("Error de SQL: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    log.debug("Error cerrando el ResulSet: " + e.getMessage());
                }
            }
        }
        return listaLibros;
    }
}
