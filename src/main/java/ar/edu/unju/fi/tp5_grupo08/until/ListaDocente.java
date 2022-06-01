package ar.edu.unju.fi.tp5_grupo08.until;

import java.util.ArrayList;
import ar.edu.unju.fi.tp5_grupo08.model.Docente;
import org.springframework.stereotype.Component;


@Component
public class ListaDocente {
	private ArrayList <Docente> docentes;


	public ListaDocente() {
		docentes = new ArrayList<Docente>();
		Docente docente1= new Docente(100,"Rocio","Guerrero","rocio@gmail.com",3886472);
		Docente docente2= new Docente(101,"Ignacio","Padilla","agustin@gmail.com",3882345);
		Docente docente3= new Docente(102,"Jose","Fernandez","joch@gmail.com",3882238);
		docentes.add(docente1);
		docentes.add(docente2);
		docentes.add(docente3);
	}
	
	public ArrayList<Docente> getDocente() {
		return docentes;
	}

	public void setDocente(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}
	
}
