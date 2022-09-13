package com.isil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

    public static void main(String[] args) throws Exception {

        String jdbcUrl = "jdbc:mysql://localhost:3306/DESAI";

        // Cargar el driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Crear la conexion
        Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");

        // Crear el statement
        Statement st = con.createStatement();

        // Ejecutar la sentencia SQL
        ResultSet rs = st.executeQuery("SELECT * FROM Users");

        // Procesar el resultado
        while (rs.next()) {
            System.out.println(
                    rs.getString("idUser") + " " +
                    rs.getString("name") + " " +
                    rs.getString("phone") + " " +
                    rs.getString("city")
            );
        }
    }
}
