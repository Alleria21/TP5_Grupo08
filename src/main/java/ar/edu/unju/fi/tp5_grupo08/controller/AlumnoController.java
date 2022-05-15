package ar.edu.unju.fi.tp5_grupo08.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5_grupo08.model.Alumno;
import ar.edu.unju.fi.tp5_grupo08.until.ListaAlumnos;



@Controller
@RequestMapping("/Alumno")
public class AlumnoController {
	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);
	private ListaAlumnos lista_alumnos=new ListaAlumnos();
	@GetMapping("/nuevo")
	public String getAlumnos(Model model) {
		
		model.addAttribute("alumno", new Alumno());
		return "nuevo_alumno";
	}
	@PostMapping("/guardar")
	public ModelAndView getListaAlumnosPage(@ModelAttribute("alumno")Alumno alumno) {
		ModelAndView mav=new ModelAndView("lista_alumno");
		if(lista_alumnos.getAlumnos().add(alumno)) {
			LOGGER.info("Se agregó un objeto al arrayList de alumnos");
		}
		mav.addObject("unAlumno", lista_alumnos.getAlumnos());
		return mav;
	}
	@GetMapping("/listaAlumnos")
	public String getListaCargada(Model model){
		model.addAttribute("unAlumno", lista_alumnos.getAlumnos());
		return "lista_alumno"; 
	}
}
