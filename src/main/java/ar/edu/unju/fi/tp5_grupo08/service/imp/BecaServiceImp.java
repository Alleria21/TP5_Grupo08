package ar.edu.unju.fi.tp5_grupo08.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5_grupo08.model.Beca;
import ar.edu.unju.fi.tp5_grupo08.model.Curso;
import ar.edu.unju.fi.tp5_grupo08.service.IBecaService;
import ar.edu.unju.fi.tp5_grupo08.until.ListaBecas;
import ar.edu.unju.fi.tp5_grupo08.until.ListaCursos;

@Service("BecaServiceImpList")
public class BecaServiceImp implements IBecaService {

	@Autowired
	private ListaBecas listaBecas;
	
	@Autowired
	private ListaCursos listaCurso;
	
	@Override
	public Curso getCurso() {
		return new Curso();
	}
	
	@Override
	public Beca getBeca() {
		return new Beca();
	}

	@Override
	public boolean guardarBeca(Beca beca) {
		boolean respuesta=true;
		for(Beca bec : listaBecas.getBecas()) {
			if(bec.getCodigo()==beca.getCodigo()) {
				respuesta = false;
			}
		}
		if(respuesta==true) {
			listaBecas.getBecas().add(beca);
		}
		return respuesta;
	}

	@Override
	public void modificarBeca(Beca beca) {
		for(Beca bec : listaBecas.getBecas()) {
			if(bec.getCodigo()==beca.getCodigo()) {
				bec.setEstado(beca.getEstado());
				bec.setFechaInicio(beca.getFechaInicio());
				bec.setFechaFin(beca.getFechaFin());
				for(Curso curs: listaCurso.getCursos()) {
					if(curs.getTitulo()==beca.getCurs().getTitulo()) {
						bec.setCurs(curs);
					}
				}
			}
		}
	}

	@Override
	public void eliminarBeca(int codigo) {
		int i=0;
		for(int a=0; a<listaBecas.getBecas().size();a++) {
			if(codigo==listaBecas.getBecas().get(a).getCodigo())
				i=a;
		}
		listaBecas.getBecas().remove(i);
	}

	@Override
	public ListaBecas getListaBecas() {
		return listaBecas;
	}

	@Override
	public Beca buscarBeca(int codigo) {
		Optional<Beca> beca = listaBecas.getBecas().stream().filter(b->b.getCodigo()==codigo).findFirst();
		return beca.get();
	}



	@Override
	public ListaCursos getListaCurso() {
		return listaCurso;
	}

}
