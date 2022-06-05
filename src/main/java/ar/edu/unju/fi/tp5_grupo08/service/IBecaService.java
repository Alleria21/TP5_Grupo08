package ar.edu.unju.fi.tp5_grupo08.service;

import ar.edu.unju.fi.tp5_grupo08.model.Beca;
import ar.edu.unju.fi.tp5_grupo08.model.Curso;
import ar.edu.unju.fi.tp5_grupo08.until.ListaBecas;
import ar.edu.unju.fi.tp5_grupo08.until.ListaCursos;

public interface IBecaService {
	public Beca getBeca();
	public boolean guardarBeca(Beca beca);
	public void modificarBeca(Beca beca);
	public void eliminarBeca(int codigo);
	public ListaBecas getListaBecas();
	public Beca buscarBeca(int codigo);
	public Curso getCurso();
	public ListaCursos getListaCurso();
	
}
