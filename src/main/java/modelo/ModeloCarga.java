package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ModeloCarga extends Conector {
		
		 public ArrayList<Carga> getTodos() {
		        
			 ArrayList<Carga> cargas = new ArrayList<>();
				
				
				try {		
					PreparedStatement pst =conexion.prepareStatement("SELECT * FROM CARGAS");
					
					ResultSet rs = pst.executeQuery();
		            while (rs.next()) {
		            	Carga carga = new Carga();
		            	rellenarCarga(carga, rs);
						

		            	cargas.add(carga);
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		        return cargas;
		    }
		 
		 public Carga getUno(int id) {
			 Carga c = new Carga();
			 String sql = "SELECT * FROM CARGAS WHERE id=?";
			 
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setInt(1,id);
				
				ResultSet rs = pst.executeQuery();
				
				rs.next();
				rellenarCarga(c, rs);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return c;
		 }
		 
		private void rellenarCarga(Carga c, ResultSet rs) throws SQLException {
			c.setId(rs.getInt("id"));
			c.setPeso(rs.getDouble("peso"));
			c.setDimensiones(rs.getString("dimensiones"));
			c.setTipo(rs.getString("tipo"));

		}
		 
		 public boolean insert(Carga c) {
			 String sql = "INSERT INTO CARGAS (PESO,DIMENSIONES,TIPO) VALUES (?,?,?)";
			 try {
				
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setDouble(1, c.getPeso());
				pst.setString(2, c.getDimensiones());
				pst.setString(3,c.getTipo());
				
				pst.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		 }
		 public boolean delete(int  id) {
			 String sql = "DELETE FROM CARGAS WHERE ID=?";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setInt(1, id);
				
				pst.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		 }
		 

		 public boolean update(Carga c) {

			 String sql = "UPDATE CARGAS SET PESO=?, DIMENSIONES=?, TIPO=? WHERE ID=?";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setDouble(1, c.getPeso());
				pst.setString(2, c.getDimensiones());
				pst.setString(3,c.getTipo());
				pst.setInt(4, c.getId());

				
				pst.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace(); 
				return false;
			}
			 
		 }
	}