package com.iplacex.JunitTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class DataBaseConnectionTest {
	
	@Test
    public void testDatabaseConnection() {
        Connection conn = null;
        try {
            // Carga el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establece la conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/bd_banco";
            String user = "root";
            String password = "H@yashibara99";
            conn = DriverManager.getConnection(url, user, password);

            // Verifica que la conexión sea válida
            assertNotNull(conn);
            
         // Imprime un mensaje de conexión exitosa
            System.out.println("Conexión exitosa a la base de datos");
            
        } catch (ClassNotFoundException | SQLException ex) {
            fail("Error al conectar a la base de datos: " + ex.getMessage());
        } finally {
            // Cierra la conexión
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    fail("Error al cerrar la conexión: " + ex.getMessage());
                }
            }
        }
    }

}
