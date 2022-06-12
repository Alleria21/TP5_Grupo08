package ar.edu.unju.fi.tp5_grupo08.service;

import ar.edu.unju.fi.tp5_grupo08.entity.Docente;
import ar.edu.unju.fi.tp5_grupo08.until.ListaDocente;

import java.util.List;

public interface IDocenteService {
    public Docente getDocente();
    public boolean guardarDocente(Docente docente);
    public void modificarDocente(Docente docente);
    public void eliminarDocente(int legajo);
    public List<Docente> getListaDocente();
    public Docente buscarDocente(int legajo);
}
