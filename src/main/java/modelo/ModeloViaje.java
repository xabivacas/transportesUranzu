package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloViaje extends Conector {
		
		 public ArrayList<Viaje> getTodos() {
		        
			 ArrayList<Viaje> viajes = new ArrayList<>();

		        try {
		            Statement st = conexion.createStatement();
		            ResultSet rs = st.executeQuery("SELECT * FROM VIAJES");
		            while (rs.next()) {
		            	Viaje viaje = new Viaje();
		            	rellenarViaje(viaje, rs);
						

		            	viajes.add(viaje);
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		        return viajes;
		    }
		 
		 public Viaje getUno(int id) {
			 Viaje v = new Viaje();
			 String sql = "SELECT * FROM VIAJES WHERE id=?";
			 
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setInt(1,id);
				
				ResultSet rs = pst.executeQuery();
				
				rs.next();
				rellenarViaje(v, rs);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return v;
		 }
		 
		private void rellenarViaje(Viaje v, ResultSet rs) throws SQLException {
			v.setId(rs.getInt("id"));
			v.setOrigen(rs.getString("origen"));
			v.setDestino(rs.getString("destino"));
			v.setFecha(rs.getDate("fecha"));

		}
		 
		 public void insert(Viaje v) {
			 String sql = "INSERT INTO VIAJES (ORIGEN,DESTINO,FECHA) VALUES (?,?,?)";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				java.util.Date fecha = v.getFecha();
				java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
				
				
				pst.setString(1, v.getOrigen());
				pst.setString(2, v.getDestino());
				pst.setDate(3,  sqlDate);
				
				pst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 public void delete(String id) {
			 String sql = "DELETE FROM VIAJES WHERE ID=?";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, id);
				
				pst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 public void update(Viaje v) {
			 String sql = "UPDATE VIAJES SET ORIGEN=?, DESTINO=?, FECHA=?  WHERE ID=?";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				java.util.Date fecha = v.getFecha();
				java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());

				
				
				pst.setString(1, v.getOrigen());
				pst.setString(2, v.getDestino());
				pst.setDate(3, sqlDate);
				pst.setInt(4, v.getId());
				
		        // Establecer la fecha en el PreparedStatement
		      
				
				pst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
	}