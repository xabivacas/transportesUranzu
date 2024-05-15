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
					PreparedStatement pst =conexion.prepareStatement("SELECT * FROM VIAJES");
					
					ResultSet rs = pst.executeQuery();
		            	
					
					while(rs.next()) {
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
		 public boolean asignarViaje(Viaje viaje,Camion camion ,Camionero camionero, java.util.Date fecha) {
			 String sql = "INSERT INTO VIAJE_CAMIONES_CAMIONEROS (CAMIONERO,MATRICULA,DESTINO,ORIGEN, FECHA) VALUES (?,?,?,?,?)";

			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, camionero.getDni());
				pst.setString(2, camion.getMatricula());
				pst.setString(3, viaje.getDestino());
				pst.setString(4, viaje.getOrigen());
				pst.setDate(5, new java.sql.Date(fecha.getTime()));
				
				pst.execute();
				return true;
			} catch (SQLException e) {
				return false;
			}
			 
		 }
		 
		 public ArrayList<Viaje> getViajesCamionero(Camionero c){
			 String sql = "CALL VIAJESDECAMIONERO(?)";
			 ArrayList<Viaje> viajes = new ArrayList<>();
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, c.getDni());
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					Viaje v = new Viaje();
					
					v.setId(rs.getInt("id"));
					v.setOrigen(rs.getString("origen"));
					v.setDestino(rs.getString("destino"));
					v.setFecha(rs.getDate("fecha"));
					
					viajes.add(v);
				}
				return viajes;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			 
		 }
		 
		 public ArrayList<Viaje> getViajesDisponibles() {
		        
			 ArrayList<Viaje> viajes = new ArrayList<>();
			 String sql = ("CALL VIAJESDISPONIBLES()");
		        try {
		            Statement st = conexion.createStatement();
		            ResultSet rs = st.executeQuery(sql);
		            while (rs.next()) {
		            	Viaje viaje = new Viaje();
		            	rellenarViaje(viaje, rs);
						

		            	viajes.add(viaje);
		            }

		        } catch (SQLException e) {
					// TODO Auto-generated catch block

		            e.printStackTrace();
		            return null;
		        }
		        return viajes;
		    }
		 public Viaje getUno(Viaje viaje) {
			 Viaje v = new Viaje();
			 String sql = "SELECT * FROM VIAJES WHERE origen=? AND destino=? and fecha=?";
			 
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1,viaje.getOrigen());
				pst.setString(2,viaje.getDestino());
				pst.setDate(3,new java.sql.Date(viaje.getFecha().getTime()));
				
				ResultSet rs = pst.executeQuery();
				
				rs.next();
				rellenarViaje(v, rs);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return v;
		 }
		 public Viaje getUno(int id) {
			 Viaje v = new Viaje();
			 String sql = "SELECT * FROM VIAJES WHERE id=?";
			 
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setInt(1, id);
				
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

		}
		 
		 public boolean insert(Viaje v) {
			 String sql = "INSERT INTO VIAJES (ORIGEN,DESTINO) VALUES (?,?)";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				java.util.Date fecha = v.getFecha();
				
				
				pst.setString(1, v.getOrigen());
				pst.setString(2, v.getDestino());
				
				pst.execute();
				return true;
			} catch (SQLException e) {
				return false;
			}
		 }
		 public boolean delete(int id) {
			 String sql = "DELETE FROM VIAJES  WHERE id=?";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setInt(1,id);
				
				pst.execute();
				return true;
			} catch (SQLException e) {
				return false;
			}
		 }
		 
		 public boolean update(Viaje v) {
			 String sql = "UPDATE VIAJES SET ORIGEN=?, DESTINO=? WHERE id=?";
			 try {
				PreparedStatement pst = conexion.prepareStatement(sql);
		
				
				pst.setString(1, v.getOrigen());
				pst.setString(2, v.getDestino());
				pst.setInt(3, v.getId());
				
		        // Establecer la fecha en el PreparedStatement
		      
				
				pst.execute();
				return true;
			} catch (SQLException e) {
				return false;
			}
			
		 }
		 
	}