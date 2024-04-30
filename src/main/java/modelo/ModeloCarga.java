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
		            Statement st = conexion.createStatement();
		            ResultSet rs = st.executeQuery("SELECT * FROM CARGAS");
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
			c.setViaje(new ModeloViaje().getUno(rs.getInt("viaje")));
			c.setTipo(rs.getString("tipo"));

		}
		 
		 public void insert(Carga c) {
			 String sql = "INSERT INTO CARGAS (PESO,DIMENSIONES,VIAJE,TIPO) VALUES (?,?,?,?)";
			 try {
				
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setDouble(1, c.getPeso());
				pst.setString(2, c.getDimensiones());
				pst.setInt(3,c.getViaje().getId());
				pst.setString(4,c.getTipo());
				
				pst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 public void delete(int  id) {
			 String sql = "DELETE FROM CARGAS WHERE ID=?";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setInt(1, id);
				
				pst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 public void update(Carga c) {
			 String sql = "UPDATE CARGAS SET PESO=?, DIMENSIONES=?, VIAJE=?, TIPO=? WHERE ID=?";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setDouble(1, c.getPeso());
				pst.setString(2, c.getDimensiones());
				pst.setInt(3,c.getViaje().getId());
				pst.setString(4,c.getTipo());
				pst.setInt(5, c.getId());

				
				pst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
	}