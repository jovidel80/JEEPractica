package com.joseoliveros.libros.database;

import com.sun.rowset.CachedRowSetImpl;
import org.apache.log4j.Logger;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;

public class DataBaseHelper {

    private static final Logger log = Logger.getLogger(DataBaseHelper.class.getPackage().getName());

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
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            sentencia = conexion.createStatement();
            filasAfectadas = sentencia.executeUpdate(consultaSQL);
        } catch (ClassNotFoundException e) {
            log.debug("Error cargando el driver: " + e.getMessage());
        } catch (SQLException e) {
            log.debug("Error de SQL: " + e.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                    log.debug("Se cerro sentencia");
                } catch (SQLException e) {
                    log.debug("Error cerrando la sentencia SQL: " + e.getMessage());
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                    log.debug("Se cerro conexion");
                } catch (SQLException e) {
                    log.debug("Error cerrando la conexion SQL: " + e.getMessage());
                }
            }
        }
        return filasAfectadas;
    }

    public ResultSet seleccionarRegistros(String consultaSQL) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(consultaSQL);
            CachedRowSet rowSet = new CachedRowSetImpl();
            rowSet.populate(rs);
            rs = rowSet.getOriginal();
        } catch (ClassNotFoundException e) {
            log.debug("Error cargando el driver: " + e.getMessage());
        } catch (SQLException e) {
            log.debug("Error de SQL " + e.getMessage());
        } 
        finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                    log.debug("Se cerró la sentencia SQL");
                } catch (SQLException e) {
                    log.debug("Error cerrando la sentencia SQL: " + e.getMessage());
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                    log.debug("Se cerró la conexión SQL");
                } catch (SQLException e) {
                    log.debug("Error cerrando la conexion SQL: " + e.getMessage());
                }
            }
        }
        return rs;
    }
}
