package ar.edu.unju.fi.tp5_grupo08.service.imp;

import ar.edu.unju.fi.tp5_grupo08.model.Docente;
import ar.edu.unju.fi.tp5_grupo08.service.IDocenteService;
import ar.edu.unju.fi.tp5_grupo08.until.ListaDocente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocenteServiceImp implements IDocenteService {

    @Autowired
    private ListaDocente listaDocente;


    @Override
    public Docente getDocente() {
        return new Docente();
    }

    @Override
    public boolean guardarDocente(Docente docente) {
        return listaDocente.getDocente().add(docente);
    }

    @Override
    public void modificarDocente(Docente docente) {
        for(Docente doc : listaDocente.getDocente()) {
            if(doc.getLegajo() == docente.getLegajo()) {
                doc.setNombre(docente.getNombre());
                doc.setApellido(docente.getApellido());
                doc.setEmail(docente.getEmail());
                doc.setTelefono(docente.getTelefono());
            }
        }
    }

    @Override
    public void eliminarDocente(int legajo) {
        listaDocente.getDocente().removeIf(d ->d.getLegajo()== legajo);
    }

    @Override
    public ListaDocente getListaDocente() {
        return listaDocente;
    }

    @Override
    public Docente buscarDocente(int legajo) {
        Optional<Docente> docente = listaDocente.getDocente().stream().filter(c ->c.getLegajo()== legajo).findFirst();
        return docente.get();
    }
}
