package ar.edu.unju.fi.tp5_grupo08.controller;


import ar.edu.unju.fi.tp5_grupo08.entity.Docente;
import ar.edu.unju.fi.tp5_grupo08.service.IDocenteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/docente")
public class DocentesController {

    @Autowired
    private IDocenteService docenteService;

    private static final Log LOGGER= LogFactory.getLog(DocentesController.class);


    private static final Log LOG= LogFactory.getLog(DocentesController.class);
    @GetMapping("/nuevo")
    public String getDocente(Model model){

        model.addAttribute("docente",docenteService.getDocente());
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
        docenteService.guardarDocente(docente);
        //docentes.add(docente);//agrega un docente a la lista
        LOG.info("Se ha agregado un docente");//informa
        ModelAndView modelAndView = new ModelAndView("lista_docente.html");//crea la vista de lista
        modelAndView.addObject("docentes",docenteService.getListaDocente());//agrega el objeto docente
        return modelAndView;//retorna la lista_docente


    }
    @GetMapping("/listadocentes")
    public String listarDocentes(Model model){
        model.addAttribute("docentes", docenteService.getListaDocente());
        return "lista_docente.html";
    }

    @GetMapping("/editar/{legajo}")
    public ModelAndView getEditarDocentePage(@PathVariable(value="legajo") int legajo) {
        ModelAndView mav = new ModelAndView("editar_docente.html");
        Docente docente= docenteService.buscarDocente(legajo);
        mav.addObject("docente", docente);
        return mav;
    }

    @PostMapping("/modificar")
    public ModelAndView editarDocente(@Validated @ModelAttribute("docente") Docente docente, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            LOGGER.info("ocurrio un error"+ docente);
            ModelAndView modelAndView = new ModelAndView("editar_docente");
            modelAndView.addObject("docente", docente);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/docente/listadocentes");
        docenteService.modificarDocente(docente);
        return modelAndView;
    }

    @GetMapping("/eliminar/{legajo}")
    public ModelAndView getElimnarDocente(@PathVariable(value="legajo") int legajo) {

        ModelAndView mav=new ModelAndView("redirect:/docente/listadocentes");
        docenteService.eliminarDocente(legajo);
        return mav;
    }

}
