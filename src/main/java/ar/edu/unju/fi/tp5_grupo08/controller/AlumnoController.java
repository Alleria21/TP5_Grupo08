package ar.edu.unju.fi.tp5_grupo08.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5_grupo08.model.Alumno;
import ar.edu.unju.fi.tp5_grupo08.service.IAlumnoService;



@Controller
@RequestMapping("/Alumno")
public class AlumnoController {
	@Autowired
	@Qualifier("AlumnoServiceImpList")
	private IAlumnoService alumnoService;
	
	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);
	//private ListaAlumnos lista_alumnos=new ListaAlumnos();
	
	@GetMapping("/nuevo")
	public String getAlumnos(Model model) {
		
		model.addAttribute("alumno", alumnoService.getAlumno());
		return "nuevo_alumno";
	}
	@PostMapping("/guardar")
	public ModelAndView getListaAlumnosPage(@Validated @ModelAttribute("alumno")Alumno alumno, 
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav= new ModelAndView("nuevo_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		ModelAndView mav=new ModelAndView("redirect:/Alumno/listaAlumnos");
		if(alumnoService.guardarAlumno(alumno)) {
			LOGGER.info("Se agregó un objeto al arrayList de alumnos");
		}
		//mav.addObject("unAlumno", alumnoService.getListaAlumno().getAlumnos());
		return mav;
	}
	@GetMapping("/listaAlumnos")
	public String getListaCargada(Model model){
		model.addAttribute("unAlumno", alumnoService.getListaAlumno().getAlumnos());
		return "lista_alumno"; 
	}
	
	@GetMapping("/editar/{dni}")
	public ModelAndView getEditarAlumnoPage(@PathVariable(value="dni")int dni) {
		ModelAndView mav= new ModelAndView("edicion_alumno");
		Alumno alumno=alumnoService.buscarAlumno(dni);
		mav.addObject("alumno",alumno);
		return mav;
	}
	@PostMapping("/modificar")
	public ModelAndView editarDatosAlumnos(@Validated @ModelAttribute("alumno")Alumno alumno, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav= new ModelAndView("edicion_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		ModelAndView mav= new ModelAndView("redirect:/Alumno/listaAlumnos");
		alumnoService.modificarAlumno(alumno);
		return mav;
	}
	@GetMapping("/eliminar/{dni}")
	public ModelAndView getEliminarAlumno(@PathVariable(value="dni")int dni) {
		ModelAndView mav=new ModelAndView("redirect:/Alumno/listaAlumnos");
		alumnoService.eliiminarAlumno(dni);
		return mav;
	}
}
