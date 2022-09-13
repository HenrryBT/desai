package com.isil.jdbc;

import java.sql.*;

public class MainApp {

    public static void main(String[] args) throws Exception {

        String jdbcUrl = "jdbc:mysql://localhost:3306/DESAI";

        // Cargar el driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Crear la conexion
        Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");

        // Crear el statement
        Statement st = con.createStatement();

//        // Ejecutar la sentencia SQL
//        ResultSet rs = st.executeQuery("SELECT * FROM Users");
//
//        // Insertar
//        int filasAfectadas = st.executeUpdate("INSERT INTO Users VALUES (1,'Juan','984444459','Vancuver');");
//
//        // Update
//        int filasAfectadas = st.executeUpdate("UPDATE Users SET name='Christian' WHERE name = 'Cueva';");
//
//        // Eliminar
//        int filasAfectadas = st.executeUpdate("DELETE FROM Users WHERE idUser = 4;");
//
//        System.out.println("Filas afectadas: " + filasAfectadas);

//        // Prepared statement para mantenimiento
//        PreparedStatement preparedStatement = con.prepareStatement("insert into Users values(?, ?, ?, ?)");
//        preparedStatement.setInt(1, 8);
//        preparedStatement.setString(2, "Marta");
//        preparedStatement.setString(3, "985454646");
//        preparedStatement.setString(4, "Bogota");
//
//        int filasAfectadas = preparedStatement.executeUpdate();
//        System.out.println("Filas afectadas: " + filasAfectadas);

        // Prepared statement para consulta
        PreparedStatement preparedStatement2 = con.prepareStatement("select * from Users where idUser = ?");
        preparedStatement2.setInt(1, 8);

        ResultSet rs = preparedStatement2.executeQuery();

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
