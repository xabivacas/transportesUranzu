package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloCamionero extends Conector {
		
		 public ArrayList<Camionero> getTodos() {
		        
			 ArrayList<Camionero> camioneros = new ArrayList<>();

		        try {
		            Statement st = conexion.createStatement();
		            ResultSet rs = st.executeQuery("SELECT * FROM camioneros");
		            while (rs.next()) {
		            	Camionero Camionero = new Camionero();
		            	Camionero.setDni(rs.getString("DNI"));
		            	Camionero.setNombre(rs.getString("Nombre"));
		            	Camionero.setApellido(rs.getString("apellido"));

		            	camioneros.add(Camionero);
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		        return camioneros;
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
	}

