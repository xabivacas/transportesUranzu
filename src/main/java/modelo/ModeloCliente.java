package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloCliente extends Conector{

	public ArrayList<Cliente> getTodos(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM CLIENTES";
		try {
			ResultSet rs = conexion.createStatement().executeQuery(sql);
			
			while(rs.next()) {
				Cliente c = new Cliente();
				
				c.setCif(rs.getString("cif"));
				c.setNombre(rs.getString("nombre"));
				c.setDireccion(rs.getString("direccion"));
				
				clientes.add(c);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
		
	}
}
