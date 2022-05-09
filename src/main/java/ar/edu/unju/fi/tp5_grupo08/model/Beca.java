package ar.edu.unju.fi.tp5_grupo08.model;

import java.time.LocalDate;

public class Beca {
	private int codigo;
	private Curso curs;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
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

	@Override
	public String toString() {
		return "Beca [codigo=" + codigo + ", curs=" + curs + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", estado=" + estado + "]";
	}
	
	
}
