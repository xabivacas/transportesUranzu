package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloCliente extends Conector{

	public ArrayList<Cliente> getTodos(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		
		try {		
			PreparedStatement pst =conexion.prepareStatement("SELECT * FROM CLIENTES");
			
			ResultSet rs = pst.executeQuery();
			
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
	 public Cliente getUno(String cif) {
		 Cliente cl = new Cliente();
		 String sql = "SELECT * FROM CLIENTES WHERE CIF=?";
		 
		 try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1,cif);
			
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			rellenarCliente(cl, rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return cl;
	 }
	 
	private void rellenarCliente(Cliente cl, ResultSet rs) throws SQLException {
		cl.setCif(rs.getString("cif"));
		cl.setNombre(rs.getString("nombre"));
		cl.setDireccion(rs.getString("direccion"));
	}
	 
	 public boolean insert(Cliente cl) {
		 String sql = "INSERT INTO CLIENTES (CIF,NOMBRE,DIRECCION) VALUES (?,?,?)";
		 try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, cl.getCif());
			pst.setString(2, cl.getNombre());
			pst.setString(3, cl.getDireccion());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	 }
	 public boolean delete(String cif) {
		 String sql = "DELETE FROM CLIENTES WHERE CIF=?";
		 try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, cif);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	 }
	 
	 public boolean update(Cliente cl) {
		 String sql = "UPDATE CLIENTES SET NOMBRE=?, DIRECCION=? WHERE CIF=?";
		 try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, cl.getNombre());
			pst.setString(2, cl.getDireccion());
			pst.setString(3, cl.getCif());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
		 
	 }
}