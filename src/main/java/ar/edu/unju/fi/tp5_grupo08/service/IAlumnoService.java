package ar.edu.unju.fi.tp5_grupo08.service;

import ar.edu.unju.fi.tp5_grupo08.model.Alumno;
import ar.edu.unju.fi.tp5_grupo08.until.ListaAlumnos;

public interface IAlumnoService {
	public Alumno getAlumno();
	public boolean guardarAlumno(Alumno alumno);
	public void modificarAlumno(Alumno alumno);
	public void eliiminarAlumno(int dni);
	public ListaAlumnos getListaAlumno();
	public Alumno buscarAlumno(int dni);
}
