package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ModeloCamionero extends Conector {
		
		 public ArrayList<Camionero> getTodos() {
		        
			 ArrayList<Camionero> camioneros = new ArrayList<>();

		        try {
		            Statement st = conexion.createStatement();
		            ResultSet rs = st.executeQuery("SELECT * FROM CAMIONEROS");
		            while (rs.next()) {
		            	Camionero camionero = new Camionero();
		            	rellenarCamionero(camionero, rs);
						

		            	camioneros.add(camionero);
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		        return camioneros;
		    }
		 
		 public Camionero getUno(String dni) {
			 Camionero c = new Camionero();
			 String sql = "SELECT * FROM CAMIONEROS WHERE dni=?";
			 
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1,dni);
				
				ResultSet rs = pst.executeQuery();
				
				rs.next();
				rellenarCamionero(c, rs);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return c;
		 }
		 
		private void rellenarCamionero(Camionero c, ResultSet rs) throws SQLException {
			c.setDni(rs.getString("dni"));
			c.setNombre(rs.getString("Nombre"));
			c.setApellido(rs.getString("apellido"));
		}
		 
		 public void insert(Camionero c) {
			 String sql = "INSERT INTO CAMIONEROS (DNI,NOMBRE,APELLIDO) VALUES (?,?,?)";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, c.getDni());
				pst.setString(2, c.getNombre());
				pst.setString(3, c.getApellido());
				
				pst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 public void delete(String dni) {
			 String sql = "DELETE FROM CAMIONEROS WHERE DNI=?";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, dni);
				
				pst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 public void update(Camionero c) {
			 String sql = "UPDATE CAMIONEROS SET NOMBRE=?, APELLIDO=? WHERE DNI=?";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, c.getNombre());
				pst.setString(2, c.getApellido());
				pst.setString(3, c.getDni());
				
				pst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
	}

