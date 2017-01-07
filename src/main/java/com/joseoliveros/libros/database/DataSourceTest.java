package com.joseoliveros.libros.database;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL("/Users/capitanjovi/IdeaProjects/JEEPractica/src/main/webapp/WEB-INF/db/jeepractica");
        jdbcDataSource.setUser("jovi");
        jdbcDataSource.setPassword("jovi");
        Connection conn = jdbcDataSource.getConnection();
        if (conn != null) {
            System.out.println("conectado");
        } else {
            System.out.println("no conectado");
        }
//        testDataSource("h2");
    }

    private static void testDataSource(String dbType) {
        DataSource ds = null;
        if ("h2".equals(dbType)) {
            ds = DataSourceFactory.getH2DataSource();
        } else if ("mysql".equals(dbType)) {
            ds = DataSourceFactory.getH2DataSource();
        } else {
            System.out.println("Invalid db type");
            return;
        }
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM LIBROS");
            while (rs.next()) {
                System.out.println(rs.getString("isbn") + " " + rs.getString("titulo") + " " + rs.getString("categoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
