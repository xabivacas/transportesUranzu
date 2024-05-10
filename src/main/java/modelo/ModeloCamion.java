package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloCamion extends Conector{

	public ArrayList<Camion> getTodos(){
	ArrayList<Camion> camiones = new ArrayList<>();
		
		
		try {		
			PreparedStatement pst =conexion.prepareStatement("SELECT * FROM CAMIONES");
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Camion c = new Camion();
				
				rellenarCamion(c, rs);
				
				camiones.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return camiones;
	}
	public Camion getUno(String matricula) {
		Camion c = new Camion();
		String sql = "SELECT * FROM CAMIONES WHERE MATRICULA=?";
		
		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, matricula);
			
			ResultSet rs = pst.executeQuery();
			
			rs.next();
				
			rellenarCamion(c, rs);
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	private void rellenarCamion(Camion c, ResultSet rs) throws SQLException {
		c.setMatricula(rs.getString("matricula"));
		c.setMarca(rs.getString("marca"));
		c.setModelo(rs.getString("modelo"));
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
	public void updateCamion(Camion c) {
		String sql ="UPDATE CAMIONES SET MARCA=?,MODELO=? WHERE MATRICULA=?";
		
		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, c.getMarca());
			pst.setString(2, c.getModelo());
			pst.setString(3, c.getMatricula());
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
