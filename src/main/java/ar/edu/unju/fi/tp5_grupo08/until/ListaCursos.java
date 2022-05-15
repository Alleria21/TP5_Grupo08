package ar.edu.unju.fi.tp5_grupo08.until;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unju.fi.tp5_grupo08.model.Curso;
import ar.edu.unju.fi.tp5_grupo08.model.Docente;

public class ListaCursos {
		private ArrayList <Curso> cursos;
		
		public ListaCursos(){
			cursos = new ArrayList<Curso>();
			Docente docente1= new Docente(100,"Rocio","Guerrero","rocio@gmail.com",3886472);
			Docente docente2= new Docente(101,"Ignacio","Padilla","agustin@gmail.com",3882345);
			Docente docente3= new Docente(102,"Jose","Fernandez","joch@gmail.com",3882238);
			Curso curso1= new Curso(1,"INGLES", "Ingles Inicial",LocalDate.parse("2022-08-05"), LocalDate.parse("2022-08-05"), 233, "Virtual", docente1);
			Curso curso2= new Curso(2,"PROGRAMACION", "Programacion Inicial",LocalDate.parse("2022-08-05"), LocalDate.parse("2022-08-05"), 235, "Virtual", docente2);
			Curso curso3= new Curso(3,"ALGEBRA", "Algebra I",LocalDate.parse("2022-08-05"), LocalDate.parse("2022-08-05"), 237, "Precencial", docente3);
			cursos.add(curso1);
			cursos.add(curso2);
			cursos.add(curso3);
		}

		public ArrayList<Curso> getCursos() {
			return cursos;
		}

		public void setCursos(ArrayList<Curso> cursos) {
			this.cursos = cursos;
		}
		
}
