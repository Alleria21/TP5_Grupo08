package ar.edu.unju.fi.tp5_grupo08.controller;

import java.util.Optional;

import ar.edu.unju.fi.tp5_grupo08.entity.Docente;
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

import ar.edu.unju.fi.tp5_grupo08.model.Curso;
import ar.edu.unju.fi.tp5_grupo08.service.ICursoService;
import ar.edu.unju.fi.tp5_grupo08.until.ListaCursos;
import ar.edu.unju.fi.tp5_grupo08.until.ListaDocente;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	@Qualifier("CursoServiceImpList")
	private ICursoService cursoService;
	
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	//private ListaCursos listarCursos = new ListaCursos();
	//private ListaDocente listarDocentes = new ListaDocente();
	
		@GetMapping("/nuevo")
		public String getFormNuevoCursosPage(Model model) {
			model.addAttribute("curso", cursoService.getCurso());
			model.addAttribute("unDocente", cursoService.getListaDocente().getDocente()); //Agregar service de Docente
			return "nuevo_curso";
		}
		
		@PostMapping("/agregar")
		public ModelAndView getListaCursoPage(@Validated @ModelAttribute("curso")Curso curso, BindingResult bindingresult) {
			if(bindingresult.hasErrors()){
				ModelAndView mav = new ModelAndView("nuevo_curso");
				mav.addObject("curso",curso);
				mav.addObject("unDocente", cursoService.getListaDocente().getDocente()); //Agregar service de Docente
				return mav;
			}
			
			ModelAndView mav = new ModelAndView("redirect:/curso/ListaCursos");
			if(cursoService.guardarCurso(curso)) {
				LOGGER.info("Se agregÃ³ un objeto al arrayList de cursos");
				Optional<Docente> docente = cursoService.getListaDocente().getDocente().stream().filter(d -> d.getLegajo() == curso.getDocente().getLegajo()).findFirst();
				curso.setDocente(docente.get());                       
			}
			return mav;
		}
		
		@GetMapping("/ListaCursos")
		public ModelAndView getListaCursos(){
			ModelAndView mav = new ModelAndView("listar_curso");
			mav.addObject("unCurso",cursoService.getListaCurso().getCursos());
			return mav;
		}
		
		@GetMapping("/editar/{codigo}")
		public ModelAndView getEditarCursoPage(@PathVariable(value = "codigo")int codigo) {
			ModelAndView mav = new ModelAndView("edicion_curso");
			Curso curso = cursoService.buscarCurso(codigo);
			mav.addObject("curso", curso);
			mav.addObject("unDocente", cursoService.getListaDocente().getDocente());
			return mav;
		}
		
		@PostMapping("/modificar")
		public ModelAndView getEditarDatosCurso(@Validated @ModelAttribute("curso")Curso curso, BindingResult bindingresult) {
			if(bindingresult.hasErrors()){
				LOGGER.info("Ha ocurrido un error en la edicion de curso");
				ModelAndView mav = new ModelAndView("edicion_curso");
				mav.addObject("curso",curso);
				mav.addObject("unDocente", cursoService.getListaDocente().getDocente());
				return mav; 
			}
			ModelAndView mav = new ModelAndView("redirect:/curso/ListaCursos");
			cursoService.modificarCurso(curso);
			//Optional<Docente> docente = listarDocentes.getDocente().stream().filter(d -> d.getLegajo() == curso.getDocente().getLegajo()).findFirst();
			//curso.setDocente(docente.get());
			//mav.addObject("unDocente", new ListaDocente().getDocente());
			return mav;
		}
		
		@GetMapping("/eliminar/{codigo}")
		public ModelAndView getEliminarAlumno(@PathVariable(value="codigo")int codigo) {
			ModelAndView mav=new ModelAndView("redirect:/curso/ListaCursos");
			cursoService.eliminarCurso(codigo);
			return mav;
		}
}