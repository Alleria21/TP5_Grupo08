package ar.edu.unju.fi.tp5_grupo08.until;

import java.util.ArrayList;

import ar.edu.unju.fi.tp5_grupo08.model.Alumno;




public class ListaAlumnos {
	private ArrayList<Alumno> alumnos;
	
	public ListaAlumnos(){
		alumnos = new ArrayList<Alumno>();
		Alumno alumno1=new Alumno(448736233, "Carlos", "Sanchez","argcarlos@gmail.com",3882724);
		Alumno alumno2=new Alumno(448736234, "Lucas", "Achoz","lucas@gmail.com",3884366);
		alumnos.add(alumno1);
		alumnos.add(alumno2);
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
}
