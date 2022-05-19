package ar.edu.unju.fi.tp5_grupo08.model;

public class Beca {
	private int codigo;
	private Curso curs;
	private String fechaInicio;
	private String fechaFin;
	private String estado;
	
	public Beca() {
		// TODO Auto-generated constructor stub
	}

	public Beca(int codigo, Curso curs, String fechaInicio, String fechaFin, String estado) {
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

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
