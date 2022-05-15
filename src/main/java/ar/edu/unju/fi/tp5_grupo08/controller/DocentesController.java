package ar.edu.unju.fi.tp5_grupo08.controller;


import ar.edu.unju.fi.tp5_grupo08.model.Docente;
import ar.edu.unju.fi.tp5_grupo08.until.ListaDocente;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/docente")
public class DocentesController {
    private static final Log LOG= LogFactory.getLog(DocentesController.class);
    private ListaDocente listaDocente=new ListaDocente();
    private List<Docente> docentes = listaDocente.crearLista();
    @GetMapping
    public String getDocente(Model model){

        model.addAttribute("docente",new Docente());
        LOG.info("Se ha asociado un objeto docente al formulario");
        return "nuevo_docente.html";
    }

    @PostMapping
    public String agregarDocente(@ModelAttribute Docente docente){
        docentes.add(docente);
        LOG.info("Se ha agregado un docente");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("docentes",docente);
        modelAndView.setViewName("nuevo_docente.html");
        return "redirect:/docente/listadocentes";
    }
    @GetMapping("/listadocentes")
    public String listarDocentes(Model model){
        model.addAttribute("docentes", docentes);
        return "lista_docente.html";
    }


}
