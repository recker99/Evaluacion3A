package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://node159531-env-6303523.jelastic.saveincloud.net:3306/bd_banco?serverTimezone=UTC", "root", "jbGAbdwkJa");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se pudo cargar el controlador JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: Fallo al conectar a la base de datos");
            e.printStackTrace();
        }
        return con;
    }
    
    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión a la base de datos");
                e.printStackTrace();
            }
        }
    }

	public static Connection obtenerConexion() {
		// TODO Auto-generated method stub
		return null;
	}

}
