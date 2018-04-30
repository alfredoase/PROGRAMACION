package Ventanas;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class ConexionDB {
	
	//DATOS DE LA CONEXION (DRIVER)
	static final String CONTROLADOR_MYSQL = "com.mysql.jdbc.Driver";
	
	//DATOS DE LA BASE DE DATOS
	private String host;
	private String bbdd;
	private String user;
	private String pass;
	private String url;
	
	//CONEXION
	private Connection conexion = null;
	
	//CONSTRUCTOR DE LA CONEXION
	public ConexionDB(String HOST, String BBDD, String USER, String PASS) {
		this.host = HOST;
		this.bbdd = BBDD;
		this.user = USER;
		this.pass = PASS;
		this.url = "jdbc:mysql://"+this.host+"/"+this.bbdd;
	}
	
	//CONECTARSE A LA BBDD
	public boolean connectDB() {
		try {
			Class.forName(CONTROLADOR_MYSQL);
			
			conexion = DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch(SQLException excepcionSql) {
			excepcionSql.printStackTrace();
			return false;
		}
		catch(ClassNotFoundException noEncontroClase) {
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Connection getConexion(){
		return this.conexion;			
	}
}