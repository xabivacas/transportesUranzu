package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conector implements Config{
	
	protected Connection conexion;

	/**
	 */
	Conector() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.conexion = DriverManager.getConnection("jdbc:mysql://" + Config.HOST + "/" + Config.BBDD, Config.USERNAME, Config.PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
	}
	
//	Conector() {
//		try {
//            String url = "jdbc:oracle:thin:@192.168.1.20:49163:xe";       
//            Properties props = new Properties();
//            props.setProperty("user", "V");
//            props.setProperty("password", "V");
//          
//            //creating connection to Oracle database 
//          
//            conexion = DriverManager.getConnection(url,props);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	
//}


	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
}