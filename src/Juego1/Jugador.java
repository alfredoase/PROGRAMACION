package Juego1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jugador {
	private int id;
	private int edad;
	private int puntuacion;
	private String nombre;
	private String apellidos;
	private String nick;
	private String correo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public Jugador() {
		
	}
	
	public String toString() {
		System.out.println("Informacion personal del jugador: "+this.nick);
		return "Nombre: "+this.nombre+" Apellidos: "+this.apellidos+" Edad:"+this.edad+" Puntuacion:"+this.puntuacion;
	}
}