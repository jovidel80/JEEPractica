package com.joseoliveros.libros.database;

import java.sql.*;

public class DataBaseHelper {

    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:/Users/capitanjovi/IdeaProjects/JEEPractica/src/main/webapp/WEB-INF/db/jeepractica";
    private static final String USER = "jovi";
    private static final String PASSWORD = "jovi";

    public int modificarRegistro(String consultaSQL) {
        Connection conexion = null;
        Statement sentencia = null;
        int filasAfectadas = 0;

        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(DRIVER, USER, PASSWORD);
            sentencia = conexion.createStatement();
            filasAfectadas = sentencia.executeUpdate(consultaSQL);
        } catch (ClassNotFoundException e) {
            System.out.println("Error driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de SQL " + e.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando la sentencia " + e.getMessage());
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando la conexión " + e.getMessage());
                }
            }
        }
        return filasAfectadas;
    }

    public ResultSet seleccionarRegistros(String consultaSQL) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet filas = null;

        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(DRIVER, USER, PASSWORD);
            sentencia = conexion.createStatement();
            filas = sentencia.executeQuery(consultaSQL);
        } catch (ClassNotFoundException e) {
            System.out.println("Error driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de SQL " + e.getMessage());
        }
        return filas;
    }
}
