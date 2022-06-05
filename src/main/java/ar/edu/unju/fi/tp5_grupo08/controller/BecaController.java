package ar.edu.unju.fi.tp5_grupo08.controller;

import java.util.Optional;

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

import ar.edu.unju.fi.tp5_grupo08.model.Beca;
import ar.edu.unju.fi.tp5_grupo08.model.Curso;
import ar.edu.unju.fi.tp5_grupo08.service.IBecaService;


@Controller
@RequestMapping("/beca")
public class BecaController {
	
	@Autowired
	@Qualifier("BecaServiceImpList")
	private IBecaService becaService;
	
	private static final Log LOGGER = LogFactory.getLog(BecaController.class);
	//private ListaBecas listarBecas = new ListaBecas();
	
		@GetMapping("/nuevo")
		public String getFormNuevoBecaPage (Model model) {
			model.addAttribute("beca", becaService.getBeca());
			model.addAttribute("unCurso", becaService.getListaCurso().getCursos());
			return "nueva_beca";
		}
		
		@PostMapping("/agregar")
		public ModelAndView getListaBecaPage(@Validated @ModelAttribute("beca")Beca beca, BindingResult bindingresult) {
			if(bindingresult.hasErrors()){
				ModelAndView mav = new ModelAndView("nueva_beca");
				mav.addObject("beca",beca);
				mav.addObject("unCurso", becaService.getListaCurso().getCursos());
				return mav;
			}
			
			ModelAndView mav = new ModelAndView("redirect:/beca/ListaBecas");
			if(becaService.guardarBeca(beca)) {
				LOGGER.info("Se agregó un objeto al arraylist de Becas");
			}
			return mav;
		}
		
		@GetMapping("/ListaBecas")
		public ModelAndView getListaBeca() {
			ModelAndView mav = new ModelAndView("lista_beca");
			mav.addObject("unaBeca",becaService.getListaBecas().getBecas());
			return mav;
		}
		
		@GetMapping("/editar/{codigo}")
		public ModelAndView getEditarBecaPage(@PathVariable(value="codigo")int codigo) {
			ModelAndView mav = new ModelAndView("edicion_beca");
			Beca beca = becaService.buscarBeca(codigo);
			mav.addObject("beca",beca);
			mav.addObject("unCurso",becaService.getListaCurso().getCursos());
			return mav;
		}
		@PostMapping("/modificar")
		public ModelAndView getEditarDatosBeca(@Validated @ModelAttribute("beca")Beca beca, BindingResult bindingresult) {
			if(bindingresult.hasErrors()){
				LOGGER.info("Ha ocurrido un error en la edicion de la beca");
				ModelAndView mav = new ModelAndView("edicion_beca");
				mav.addObject("beca",beca);
				mav.addObject("unCurso", becaService.getListaCurso().getCursos());
				return mav;
			}
			ModelAndView mav = new ModelAndView("redirect:/beca/ListaBecas");
			becaService.modificarBeca(beca);
			return mav;
		}
		@GetMapping("/eliminar/{codigo}")
		public ModelAndView getEliminarBeca(@PathVariable(value="codigo")int codigo) {
			ModelAndView mav=new ModelAndView("redirect:/beca/ListaBecas");
			becaService.eliminarBeca(codigo);
			return mav;
			
		}
	
}