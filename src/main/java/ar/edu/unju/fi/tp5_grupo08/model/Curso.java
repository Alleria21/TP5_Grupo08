package ar.edu.unju.fi.tp5_grupo08.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class Curso {
	@Min(value = 1, message = "*El valor del código debe ser mayor o igual a 1")
	@Max(value = 9999, message = "*El valor del codigo debe ser menor o igual a 9999")
	private int codigo;
	
	@NotEmpty(message = "*Debe ingresar un título")
	private String titulo;
	
	@NotEmpty(message = "*Debe ingresar una categoría")
	private String categoria;
	
	@NotNull(message = "*Debe ingresar una fecha") 
	@FutureOrPresent(message = "*La fecha debe ser igual o posterior a la actual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicio;
	
	@NotNull(message = "*Debe ingresar una fecha") 
	@Future(message = "*La fecha debe ser posterior a la actual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaFin;
	
	@Min(value = 1, message = "*El valor de las horas debe ser mayor o igual a 1")
	private int horas;
	
	@NotEmpty(message = "*Debe ingresar una modalidad")
	private String modalidad;
	
	@NotNull(message= "*Debe elegir un docente")
	private Docente docente;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso( int codigo, String titulo,String categoria, LocalDate fechaInicio, LocalDate fechaFin, int horas, String modalidad,Docente docente) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horas = horas;
		this.modalidad = modalidad;
		this.docente = docente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
}
