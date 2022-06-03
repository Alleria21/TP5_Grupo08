package ar.edu.unju.fi.tp5_grupo08.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5_grupo08.model.Curso;
import ar.edu.unju.fi.tp5_grupo08.model.Docente;
import ar.edu.unju.fi.tp5_grupo08.service.ICursoService;
import ar.edu.unju.fi.tp5_grupo08.until.ListaCursos;
import ar.edu.unju.fi.tp5_grupo08.until.ListaDocente;

@Service("CursoServiceImpList")
public class CursoServiceImp implements ICursoService {

	@Autowired
	private ListaCursos listaCurso;
	
	@Autowired
	private ListaDocente listaDocente;
	
	@Override
	public Docente getDocente() {
		return new Docente();
	}
	
	@Override
	public Curso getCurso() {
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		boolean respuesta=true;
		for(Curso curs : listaCurso.getCursos()) {
			if(curs.getCodigo()==curso.getCodigo()) {
				respuesta = false;
			}
		}
		if(respuesta==true) {
			listaCurso.getCursos().add(curso);
		}
		return respuesta;
	}

	@Override
	public void modificarCurso(Curso curso) {
		for(Curso curs : listaCurso.getCursos()) {
			if(curs.getCodigo()==curso.getCodigo()) {
				curs.setTitulo(curso.getTitulo());
				curs.setCategoria(curso.getCategoria());
				curs.setFechaInicio(curso.getFechaInicio());
				curs.setFechaFin(curso.getFechaFin());
				curs.setHoras(curso.getHoras());
				curs.setModalidad(curso.getModalidad());
				
				for(Docente doc: listaDocente.getDocente()) {
					if(doc.getLegajo()==curso.getDocente().getLegajo()) {
						curs.setDocente(doc);
					}
				}
			}
		}
	}

	@Override
	public void eliminarCurso(int codigo) {
		int indice = 0;
		for(int i=0; i<listaCurso.getCursos().size(); i++) {
			if(codigo==listaCurso.getCursos().get(i).getCodigo()) {
				indice=i;
			}
		}
		listaCurso.getCursos().remove(indice);
	}

	@Override
	public ListaCursos getListaCurso() {
		return listaCurso;
	}

	@Override
	public Curso buscarCurso(int codigo) {
		Optional<Curso> curso = listaCurso.getCursos().stream().filter(c -> c.getCodigo()==codigo).findFirst();
		return curso.get();
	}

	@Override
	public ListaDocente getListaDocente() {
		return listaDocente;
	}
}
