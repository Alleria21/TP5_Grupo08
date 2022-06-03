package ar.edu.unju.fi.tp5_grupo08.service.imp;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5_grupo08.model.Alumno;
import ar.edu.unju.fi.tp5_grupo08.service.IAlumnoService;
import ar.edu.unju.fi.tp5_grupo08.until.ListaAlumnos;


@Service("AlumnoServiceImpList")
public class AlumnoServiceImp implements IAlumnoService {

	@Autowired
	private ListaAlumnos listaAlumno;
	
	@Override
	public Alumno getAlumno() {
		// retorna un Objeto de la clase Alumno
		return new Alumno();
	}

	@Override
	public boolean guardarAlumno(Alumno alumno) {
		boolean respuesta=true;
		for(Alumno alu: listaAlumno.getAlumnos()) {
			if(alu.getDin()==alumno.getDin()) {
				respuesta=false;
			}
		}
		if(respuesta==true) {
			listaAlumno.getAlumnos().add(alumno);
		}
		return respuesta;
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		for(Alumno alu:listaAlumno.getAlumnos()) {
			if(alu.getDin()==alumno.getDin()) {
				alu.setApellido(alumno.getApellido());
				alu.setEmail(alumno.getEmail());
				alu.setNombre(alumno.getNombre());
				alu.setTelefono(alumno.getTelefono());
			}
		}
	}

	@Override
	public void eliiminarAlumno(int dni) {
		int indice=0;
		for(int i=0;i<listaAlumno.getAlumnos().size();i++) {
			if(listaAlumno.getAlumnos().get(i).getDin()==dni) {
				indice=i;
			}
		}
		listaAlumno.getAlumnos().remove(indice);
	}

	@Override
	public ListaAlumnos getListaAlumno() {
		// TODO Auto-generated method stub
		return listaAlumno;
	}

	@Override
	public Alumno buscarAlumno(int dni) {
		Optional<Alumno> alumno=listaAlumno.getAlumnos().stream().filter(a -> a.getDin()==dni).findFirst();
		return alumno.get();
	}

}
