package ar.edu.unju.fi.tp5_grupo08.controller;

import java.util.Optional;

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

import ar.edu.unju.fi.tp5_grupo08.model.Curso;
import ar.edu.unju.fi.tp5_grupo08.model.Docente;
import ar.edu.unju.fi.tp5_grupo08.until.ListaCursos;
import ar.edu.unju.fi.tp5_grupo08.until.ListaDocente;

@Controller
@RequestMapping("/curso")
public class CursoController {
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	private ListaCursos listarCursos = new ListaCursos();
	private ListaDocente listarDocentes = new ListaDocente();
	
		@GetMapping("/nuevo")
		public String getFormNuevoCursosPage(Model model) {
			model.addAttribute("curso", new Curso());
			model.addAttribute("unDocente", new ListaDocente().getDocente()); //Lista para el Select del formulario
			return "nuevo_curso";
		}
		
		@PostMapping("/agregar")
		public ModelAndView getListaCursoPage(@Validated @ModelAttribute("curso")Curso curso, BindingResult bindingresult) {
			if(bindingresult.hasErrors()){
				ModelAndView mav = new ModelAndView("nuevo_curso");
				mav.addObject("curso",curso);
				mav.addObject("unDocente", new ListaDocente().getDocente()); //Lista para el Select del formulario
				return mav;
			}
			
			ModelAndView mav = new ModelAndView("listar_curso");
			if(listarCursos.getCursos().add(curso)) {
				LOGGER.info("Se agregó un objeto al arrayList de cursos");
				Optional<Docente> docente = listarDocentes.getDocente().stream().filter(d -> d.getLegajo() == curso.getDocente().getLegajo()).findFirst();
				curso.setDocente(docente.get());                       
			}
			mav.addObject("unCurso",listarCursos.getCursos());
			return mav;
		}
		
		@GetMapping("/ListaCursos")
		public ModelAndView getListaCursos(){
			ModelAndView mav = new ModelAndView("listar_curso");
			mav.addObject("unCurso",listarCursos.getCursos());
			return mav;
		}
	}
