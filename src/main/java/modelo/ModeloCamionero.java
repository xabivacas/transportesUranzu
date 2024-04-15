package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloCamionero {
		
	public class ModeloTareas extends Conector {
		
		 public ArrayList<Camionero> getTodos() {
		        
			 ArrayList<Camionero> camioneros = new ArrayList<>();

		        try {
		            Statement st = conexion.createStatement();
		            ResultSet rs = st.executeQuery("SELECT * FROM tareas");
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
	}
}
