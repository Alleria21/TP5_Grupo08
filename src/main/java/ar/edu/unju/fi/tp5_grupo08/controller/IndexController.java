package ar.edu.unju.fi.tp5_grupo08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tp5_grupo08.until.ListaAlumnos;
import ar.edu.unju.fi.tp5_grupo08.until.ListaBecas;




@Controller
public class IndexController {

	@GetMapping("/inicio")
	public String getIndexController(Model model) {
		return "index";
	}
	@GetMapping("/agenda")
	public String getAgenda(Model model) {
		return "agenda";
	}
	
	@GetMapping("/beneficios")
	public String getBeneficios(Model model) {
		ListaBecas listaBecas=new ListaBecas();
		model.addAttribute("becas",listaBecas.getBecas());
		
		ListaAlumnos listaAlumnos=new ListaAlumnos();
		model.addAttribute("alumnos",listaAlumnos.getAlumnos());
		return "beneficios";
	}
	@GetMapping("/contacto")
	public String getContacto(Model model) {
		return "contacto";
	}
}
