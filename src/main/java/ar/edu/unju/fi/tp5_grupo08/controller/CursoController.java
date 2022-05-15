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

import ar.edu.unju.fi.tp5_grupo08.model.Curso;
import ar.edu.unju.fi.tp5_grupo08.until.ListaCursos;

@Controller
@RequestMapping("/curso")
public class CursoController {
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	private ListaCursos listarCursos = new ListaCursos();
	
		@GetMapping("/nuevo")
		public String getFormNuevoCursosPage(Model model) {
			model.addAttribute("curso", new Curso());
			return "nuevo_curso";
		}
		
		@PostMapping("/agregar")
		public ModelAndView getListaCursoPage(@ModelAttribute("curso")Curso curso) {
			ModelAndView mav = new ModelAndView("listar_curso");
			if(listarCursos.getCursos().add(curso)) {
				LOGGER.info("Se agregó un objeto al arrayList de cursos");
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
