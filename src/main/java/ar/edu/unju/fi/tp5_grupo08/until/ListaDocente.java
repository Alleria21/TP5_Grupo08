package ar.edu.unju.fi.tp5_grupo08.until;

import ar.edu.unju.fi.tp5_grupo08.model.Docente;

import java.util.ArrayList;
import java.util.List;

public class ListaDocente {
    public List<Docente> crearLista(){
        List<Docente> listaDocentes= new ArrayList<>();
        listaDocentes.add(new Docente(1,"Graciela","Perez","gracielaperez@email.com",155489635));
        listaDocentes.add(new Docente(2,"Pedro","Cruz","pedrocruz@email.com",155423456));
        listaDocentes.add(new Docente(3,"Marcos","Julian","marcosjulian@email.com",155823457));
        return listaDocentes;

    }
}
