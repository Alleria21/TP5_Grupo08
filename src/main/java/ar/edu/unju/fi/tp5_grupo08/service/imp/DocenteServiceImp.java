package ar.edu.unju.fi.tp5_grupo08.service.imp;

import ar.edu.unju.fi.tp5_grupo08.entity.Docente;
import ar.edu.unju.fi.tp5_grupo08.repository.DocenteRepository;
import ar.edu.unju.fi.tp5_grupo08.service.IDocenteService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocenteServiceImp implements IDocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    public Docente getDocente() {
        return new Docente();
    }

    @Override
    public boolean guardarDocente(Docente docente) {
        docente.setEstado(true);
        if(docenteRepository.save(docente)!= null) {
            return true;
        }
        return false;
    }

    @Override
    public void modificarDocente(Docente docente) {
        //docenteRepository.save(docente);
        Docente doc = docenteRepository.findByLegajo(docente.getLegajo());
        doc.setNombre(docente.getNombre());
        doc.setApellido(docente.getApellido());
        doc.setEmail(docente.getEmail());
        doc.setTelefono(docente.getTelefono());
        docenteRepository.save(doc);
    }

    @Override
    @Transactional
    public void eliminarDocente(int legajo) {
        Docente docente = buscarDocente(legajo);
        docente.setEstado(false);
        docenteRepository.save(docente);
    }

    @Override
    public List<Docente> getListaDocente() {
        //return docenteRepository.findAll();
        return docenteRepository.findByEstado(true);
    }

    @Override
    public Docente buscarDocente(int legajo) {
        return docenteRepository.findByLegajo(legajo);
    }
}
