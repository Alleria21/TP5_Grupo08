package ar.edu.unju.fi.tp5_grupo08.repository;

import ar.edu.unju.fi.tp5_grupo08.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
    public Docente findByLegajo(int legajo);

    @Modifying
    @Query("delete from Docente d where d.legajo = ?1")
    public void deleteByLegajo(int legajo);

    public List<Docente> findByEstado(boolean estado);

    @Query("select d from Docente d order by d.legajo")
    public List<Docente> obtenerDocentesOrdenadoPorLegajo();
}
