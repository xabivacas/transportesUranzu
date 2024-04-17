package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloCamion extends Conector{

	public ArrayList<Camion> getAll(){
		ArrayList<Camion> camiones = new ArrayList<>();
		String sql = "SELECT * FROM CAMIONES";
		
		try {
			ResultSet rs = conexion.createStatement().executeQuery(sql);
			
			while(rs.next()) {
				Camion c = new Camion();
				
				c.setMatricula(rs.getString("matricula"));
				c.setMarca(rs.getString("marca"));
				c.setModelo(rs.getString("modelo"));
				
				camiones.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return camiones;
	}
	
	public void insertCamion(Camion c) {
		String sql = "INSERT INTO CAMIONES (MATRICULA,MARCA,MODELO) VALUES (?,?,?)";
		
		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, c.getMatricula());
			pst.setString(2, c.getMarca());
			pst.setString(3, c.getModelo());
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void deleteCamion(String matricula) {
		String sql = "DELETE FROM CAMIONES WHERE MATRICULA=?";
		
		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, matricula);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
