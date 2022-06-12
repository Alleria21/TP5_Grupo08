package ar.edu.unju.fi.tp5_grupo08.service;

import ar.edu.unju.fi.tp5_grupo08.entity.Docente;
import ar.edu.unju.fi.tp5_grupo08.model.Curso;
import ar.edu.unju.fi.tp5_grupo08.until.ListaCursos;
import ar.edu.unju.fi.tp5_grupo08.until.ListaDocente;

public interface ICursoService { //metodos abstractcos
	public Curso getCurso();
	public boolean guardarCurso(Curso curso);
	public void modificarCurso(Curso curso);
	public void eliminarCurso(int codigo);
	public ListaCursos getListaCurso();
	public Curso buscarCurso(int codigo);
	public Docente getDocente();
	public ListaDocente getListaDocente();
	
}