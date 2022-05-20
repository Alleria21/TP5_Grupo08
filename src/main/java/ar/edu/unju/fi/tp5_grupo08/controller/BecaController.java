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

import ar.edu.unju.fi.tp5_grupo08.model.Beca;
import ar.edu.unju.fi.tp5_grupo08.until.ListaBecas;


@Controller
@RequestMapping("/beca")
public class BecaController {
	private static final Log LOGGER = LogFactory.getLog(BecaController.class);
	private ListaBecas listarBecas = new ListaBecas();
	
		@GetMapping("/nuevo")
		public String getFormNuevoBecaPage (Model model) {
			model.addAttribute("beca", new Beca());
			return "nueva_beca";
		}
		
		@PostMapping("/agregar")
		public ModelAndView getListaBecaPage(@ModelAttribute("beca")Beca beca) {
			ModelAndView mav = new ModelAndView("lista_beca");
			if(listarBecas.getBecas().add(beca)) {
				LOGGER.info("Se agregó un objeto al arraylist de Becas");
			}
			mav.addObject("unaBeca",listarBecas.getBecas());
			return mav;
		}
		
		@GetMapping("/ListaBecas")
		public ModelAndView getListaBeca() {
			ModelAndView mav = new ModelAndView("lista_beca");
			mav.addObject("unaBeca",listarBecas.getBecas());
			return mav;
		}
		

}