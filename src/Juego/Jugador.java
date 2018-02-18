package Juego;

public class Jugador {
	private int id;
	private int edad;
	private int puntuacion;
	private String nombre;
	private String apellidos;
	private String nick;
	private String correo;
	private String dificultad;
	private String temporizadorDadosON;
	
	// GETTER
	public int getId() {
		return id;
	}
	//SETTER
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
	
	public String getDificultad(){ 
		return dificultad; 
	}
	public void setDificultad(String dificultad){ 
		this.dificultad = dificultad; 
	}
	
	public String getActivarTemporizador() {
		return temporizadorDadosON;
	}
	public void setActivarTemporizador(String temporizadorDadosON) {
		this.temporizadorDadosON = temporizadorDadosON;
	}

	public Jugador() {
		
	}
}