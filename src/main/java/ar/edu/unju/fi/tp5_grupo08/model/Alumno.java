package ar.edu.unju.fi.tp5_grupo08.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

public class Alumno {
	@Min(value=1000000, message="El n° de DNI debe ser mayor a 1.000.000")
	private int din;
	@Size(min=3, max=100, message="El nombre debe tener entre 3 a 100 caracteres")
	@NotEmpty
	private String nombre;
	@Size(min=3, max=100, message="El apellido debe tener entre 3 a 100 caracteres")
	@NotEmpty
	private String apellido;
	@Email
	private String email;
	@NumberFormat(pattern="3886")
	@Positive(message="El numero de telefono debe ser mayor a 0")
	@NotNull(message="El numero de telefono no puede ser vacio")
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
