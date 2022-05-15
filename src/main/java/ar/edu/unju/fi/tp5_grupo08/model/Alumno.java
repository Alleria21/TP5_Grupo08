package ar.edu.unju.fi.tp5_grupo08.model;


public class Alumno {
	private int din;
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public Alumno(int din, String nombre, String apellido, String email, int telefono) {
		super();
		this.din = din;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public int getDin() {
		return din;
	}
	
	public void setDin(int din) {
		this.din = din;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	
}
