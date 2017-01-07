package com.joseoliveros.libros.database;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataSourceFactory {

    public static DataSource getH2DataSource() {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        Properties properties = new Properties();
        InputStream inputStream = null;
        JdbcDataSource h2ds = null;

        try {
            inputStream = classLoader.getResourceAsStream("db.properties");
            properties.load(inputStream);
            h2ds = new JdbcDataSource();
            h2ds.setUrl(properties.getProperty("H2_DB_URL"));
            System.out.println(properties.getProperty("H2_DB_URL"));
            h2ds.setUser(properties.getProperty("H2_DB_USERNAME"));
            System.out.println(properties.getProperty("H2_DB_USERNAME"));
            h2ds.setPassword(properties.getProperty("H2_DB_PASSWORD"));
            System.out.println(properties.getProperty("H2_DB_PASSWORD"));
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return h2ds;
    }
}
