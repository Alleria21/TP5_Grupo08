package ar.edu.unju.fi.tp5_grupo08.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "docentes")
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "docente_id")
	private long id;

	@Positive(message = "Debe ingresar valores positivos")
	@Column(name = "docente_legajo")
	private int legajo;
	@NotBlank(message = "El campo Nombre no puede estar en blanco")
	@NotNull(message = "El campo Nombre no puede ser nulo ")
	@Column(name = "docente_nombre")
	private String nombre;

	@NotBlank(message = "El campo Apellido no puede estar en blanco")
	@NotNull(message = "El campo Apellido no puede ser nulo ")
	@Column(name = "docente_apellido")
	private String apellido;

	@Email(message = "Debe ingresar un correo electronico válido")
	@NotNull(message = "El campo Email no puede ser nulo")
	@Column(name = "docente_email")
	private String email;

	@Positive(message = "Debe ingresar valores positivos")
	@NotNull(message = "El campo Telefono no puede ser nulo")
	@Column(name = "docente_telefono")
	private int telefono;

	@Column(name = "docente_estado")
	private boolean estado;

	/*@OneToMany(mappedBy = "docentes")
	private List<Curso> cursos = new ArrayList<Curso>();*/
	public Docente() {

	}

	public Docente(int legajo, String nombre, String apellido, String email, int telefono, boolean estado) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/*public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}*/

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
