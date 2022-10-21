package tn.iit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tn.iit.dto.EtudiantDto;

@Controller
@RequestMapping("/hello-controller") // url d'accès au controlleur
public class HelloThymeleafController {

	@GetMapping("/time1") // url d'accès à la méthode
	public ModelAndView goToThymeleaf() {
		ModelAndView modelAndView = new ModelAndView(); // controlleur --> vue
		modelAndView.addObject("serverTime", new SimpleDateFormat("hh:mm:ss").format(new Date()));

		modelAndView.setViewName("hello-thymeleaf"); // --> hello-thymeleaf.html dans le répertoire template
		return modelAndView;
	}

	@GetMapping("/time2") // url d'accès à la méthode
	public String goToThymeleaf2(Model model) { // model: Vue <--> Controlleur
		model.addAttribute("serverTime", new SimpleDateFormat("hh:mm:ss").format(new Date()));
		return "hello-thymeleaf"; // --> hello-thymeleaf.html dans le répertoire template
	}

	@GetMapping("/list") // url d'accès à la méthode
	public String goToThymeleaf3(Model model) { // model: Vue <--> Controlleur
		model.addAttribute("listeName", "Liste des étudiants");
		List<EtudiantDto> etudiantDtos = new ArrayList<>();
		etudiantDtos.add(new EtudiantDto("Hbiri", "Ikram", 'F'));
		etudiantDtos.add(new EtudiantDto("Mrabet", "Hamdi", 'M'));
		model.addAttribute("etudiantDtos", etudiantDtos);
		return "hello-thymeleaf"; // --> hello-thymeleaf.html dans le répertoire template
	}

	@ResponseBody // la méthode retourne du JSON
	@GetMapping("/json") // url d'accès à la méthode
	public List<EtudiantDto> goToJSON() {
		List<EtudiantDto> etudiantDtos = new ArrayList<>();
		etudiantDtos.add(new EtudiantDto("Hbiri", "Karim", 'M'));
		etudiantDtos.add(new EtudiantDto("Mrabet", "Hamdi", 'M'));
		return etudiantDtos;
	}

}
