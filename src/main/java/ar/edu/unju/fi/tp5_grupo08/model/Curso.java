package ar.edu.unju.fi.tp5_grupo08.model;

import java.time.LocalDate;

public class Curso {
	private int codigo;
	private String titulo;
	private String Categoria;
	private LocalDate fechaInicio;
	private LocalDate fechafin;
	private int horas;
	private String modalidad;
	private Docente docente;
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	public Curso(int codigo, String titulo, String categoria, LocalDate fechaInicio, LocalDate fechafin, int horas,
			String modalidad, Docente docente) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		Categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechafin = fechafin;
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
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechafin() {
		return fechafin;
	}
	public void setFechafin(LocalDate fechafin) {
		this.fechafin = fechafin;
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
