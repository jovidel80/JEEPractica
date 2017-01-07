package com.joseoliveros.libros.database;

import com.sun.rowset.CachedRowSetImpl;
import org.apache.log4j.Logger;

import javax.sql.rowset.CachedRowSet;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DataBaseHelper {

    private static final Logger log = Logger.getLogger(DataBaseHelper.class.getPackage().getName());

    private ClassLoader cl = Thread.currentThread().getContextClassLoader();
    private Properties prop = null;
    private InputStream inputStream = null;

    public int modificarRegistro(String consultaSQL) {
        Connection conexion = null;
        Statement sentencia = null;
        int filasAfectadas = 0;

        try {
            prop = new Properties();
            inputStream = cl.getResourceAsStream("db.properties");
            prop.load(inputStream);
            Class.forName(prop.getProperty("H2_DB_DRIVER_CLASS"));
            log.debug("Cargando Driver: " + prop.getProperty("H2_DB_DRIVER_CLASS"));
            conexion = DriverManager.getConnection(prop.getProperty("H2_DB_URL"),
                    prop.getProperty("H2_DB_USERNAME"),
                    prop.getProperty("H2_DB_PASSWORD"));
            log.debug("Haciendo conexión con la URL = " + prop.getProperty("H2_DB_URL"));
            log.debug("Usuario y password correctos");
            inputStream.close();
            sentencia = conexion.createStatement();
            filasAfectadas = sentencia.executeUpdate(consultaSQL);
        } catch (ClassNotFoundException e) {
            log.debug("Error cargando el driver: " + e.getMessage());
        } catch (SQLException e) {
            log.debug("Error de SQL: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
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
            inputStream = cl.getResourceAsStream("db.properties");
            prop = new Properties();
            prop.load(inputStream);
            Class.forName(prop.getProperty("H2_DB_DRIVER_CLASS"));
            log.debug("Cargando Driver: " + prop.getProperty("H2_DB_DRIVER_CLASS"));
            conexion = DriverManager.getConnection(prop.getProperty("H2_DB_URL"),
                    prop.getProperty("H2_DB_USERNAME"),
                    prop.getProperty("H2_DB_PASSWORD"));
            log.debug("Haciendo conexión con la URL = " + prop.getProperty("H2_DB_URL"));
            log.debug("Usuario y password correctos");
            inputStream.close();
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(consultaSQL);
            CachedRowSet rowSet = new CachedRowSetImpl();
            rowSet.populate(rs);
            rs = rowSet.getOriginal();
        } catch (ClassNotFoundException e) {
            log.debug("Error cargando el driver: " + e.getMessage());
        } catch (SQLException e) {
            log.debug("Error de SQL " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
