package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utils.Conexion;

public class LoginDAO {
	public static int validar(String username, String password) {
        Connection con = null;
        Conexion cn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int valido = 0;
        String sql = "SELECT * FROM bd_banco.usuario WHERE username = ? AND password = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username); // Establecer el valor del primer parámetro
            ps.setString(2, password); // Establecer el valor del segundo parámetro
            rs = ps.executeQuery();
            if (rs.next()) {
                valido = 1; // Usuario válido
            } else {
                valido = 0; // Usuario inválido
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return valido;
    }
	
	public static Persona obtenerDatosPersona(String username, String password) {
        Connection con = null;
        Conexion cn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Persona persona = null;
        String sql = "SELECT persona.rut, persona.nombre, persona.apellido " +
                     "FROM persona INNER JOIN usuario ON persona.rut = usuario.rut " +
                     "WHERE usuario.username = ? AND usuario.password = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username); // Establecer el valor del primer parámetro
            ps.setString(2, password); // Establecer el valor del segundo parámetro
            rs = ps.executeQuery();
            if (rs.next()) {
                String rut = rs.getString("rut");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                persona = new Persona(rut, nombre, apellido, telefono, null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return persona;
    }
}


