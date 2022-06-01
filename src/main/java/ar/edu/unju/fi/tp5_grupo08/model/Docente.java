package ar.edu.unju.fi.tp5_grupo08.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Docente {

	@Positive(message = "Debe ingresar valores positivos")
	private int legajo;
	@NotBlank(message = "El campo Nombre no puede estar en blanco")
	@NotNull(message = "El campo Nombre no puede ser nulo ")
	private String nombre;

	@NotBlank(message = "El campo Apellido no puede estar en blanco")
	@NotNull(message = "El campo Apellido no puede ser nulo ")
	private String apellido;

	@Email(message = "Debe ingresar un correo electronico válido")
	@NotNull(message = "El campo Email no puede ser nulo")
	private String email;

	@Positive(message = "Debe ingresar valores positivos")
	@NotNull(message = "El campo Telefono no puede ser nulo")
	private int telefono;
	
	public Docente() {
		// TODO Auto-generated constructor stub
	}

	public Docente(int legajo, String nombre, String apellido, String email, int telefono) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	
	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
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
