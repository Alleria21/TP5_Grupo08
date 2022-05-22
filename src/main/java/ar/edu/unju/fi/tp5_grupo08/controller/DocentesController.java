package ar.edu.unju.fi.tp5_grupo08.controller;


import ar.edu.unju.fi.tp5_grupo08.model.Docente;
import ar.edu.unju.fi.tp5_grupo08.until.ListaDocente;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    private List<Docente> docentes = listaDocente.getDocente();
    @GetMapping("/nuevo")
    public String getDocente(Model model){

        model.addAttribute("docente",new Docente());
        LOG.info("Se ha asociado un objeto docente al formulario");
        return "nuevo_docente.html";
    }

    @PostMapping("/agregar")
    public ModelAndView agregarDocente(@Validated @ModelAttribute Docente docente, BindingResult bindingResult){

        if(bindingResult.hasErrors()){ //si tiene errores
            LOG.info("Error agregando un docente");//informa el error
            ModelAndView modelAndView = new ModelAndView("nuevo_docente.html");//vuelvo a crear vista formulario
            modelAndView.addObject("docente",docente);//paso un docente
            return modelAndView;//retorna la vista del formulario
        }
        //si no hay errores
        docentes.add(docente);//agrega un docente a la lista
        LOG.info("Se ha agregado un docente");//informa
        ModelAndView modelAndView = new ModelAndView("lista_docente.html");//crea la vista de lista
        modelAndView.addObject("docentes",docentes);//agrega el objeto docente
        return modelAndView;//retorna la lista_docente


    }
    @GetMapping("/listadocentes")
    public String listarDocentes(Model model){
        model.addAttribute("docentes", docentes);
        return "lista_docente.html";
    }


}
