package ar.edu.unju.fi.tp5_grupo08.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

public class Beca {
	
	@Positive(message= "Debe ingresar valores positivos")
	private int codigo;

	private Curso curs;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "*La fecha debe ser igual o posterior a la actual")
	@NotNull(message="No puede dejar el campo con valores nulos")
	private LocalDate fechaInicio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message="Debe ingresar una fecha posterior a la actual")
	@NotNull(message="No puede dejar el campo con valores nulos")
	private LocalDate fechaFin;
	
	@NotBlank(message="Debe ingresar el nombre de estado. El campo no puede estar en blanco")
	@NotNull(message=" El campo no puede ser nulo")
	private String estado;
	
	public Beca() {
		// TODO Auto-generated constructor stub
	}

	public Beca(int codigo, Curso curs, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
		super();
		this.codigo = codigo;
		this.curs = curs;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Curso getCurs() {
		return curs;
	}

	public void setCurs(Curso curs) {
		this.curs = curs;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
