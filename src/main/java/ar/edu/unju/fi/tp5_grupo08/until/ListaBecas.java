package ar.edu.unju.fi.tp5_grupo08.until;

import java.time.LocalDate;
import java.util.ArrayList;
import ar.edu.unju.fi.tp5_grupo08.model.Beca;
import ar.edu.unju.fi.tp5_grupo08.model.Curso;
import ar.edu.unju.fi.tp5_grupo08.model.Docente;

public class ListaBecas {
	private ArrayList <Beca> becas;
	
	public ListaBecas() {
		becas = new ArrayList<Beca>();
		Docente docente1= new Docente(100,"Rocio","Guerrero","rocio@gmail.com",3886472);
		Docente docente2= new Docente(101,"Ignacio","Padilla","agustin@gmail.com",3882345);
		Docente docente3= new Docente(102,"Jose","Fernandez","joch@gmail.com",3882238);
		Curso curso1= new Curso(1,"INGLES", "Ingles Inicial",LocalDate.parse("2022-08-05"), LocalDate.parse("2022-09-05"), 233, "Virtual", docente1);
		Curso curso2= new Curso(2,"PROGRAMACION", "Programacion Inicial",LocalDate.parse("2022-06-10"), LocalDate.parse("2022-09-24"), 235, "Virtual", docente2);
		Curso curso3= new Curso(3,"ALGEBRA", "Algebra I",LocalDate.parse("2022-06-10"), LocalDate.parse("2022-10-10"), 237, "Precencial", docente3);
		becas.add(new Beca(1, curso1, LocalDate.parse("2022-08-05"),LocalDate.parse("2020-09-05"),"Abierto"));
		becas.add(new Beca(2, curso2, LocalDate.parse("2022-08-05"),LocalDate.parse("2020-09-05"),"Abierto"));
		becas.add(new Beca(3, curso3, LocalDate.parse("2022-08-05"),LocalDate.parse("2020-09-05"),"Abierto"));
	}

	public ArrayList<Beca> getBecas() {
		return becas;
	}

	public void setBecas(ArrayList<Beca> becas) {
		this.becas = becas;
	}

}
