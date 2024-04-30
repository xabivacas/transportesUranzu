package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloUsuario extends Conector{

	public User getUser(String nombre) {
		User user = new User();
		String sql = "SELECT * FROM USUARIOS WHERE NOMBRE=?";
		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, nombre);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			user.setNombre(rs.getString("nombre"));
			user.setContrasenia(rs.getString("contrasenia"));
			user.setTipo(rs.getString("tipo"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return user;
	}
}
