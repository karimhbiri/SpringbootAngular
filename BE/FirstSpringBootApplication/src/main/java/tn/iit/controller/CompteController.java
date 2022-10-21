package tn.iit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tn.iit.entity.Client;
import tn.iit.entity.Compte;
import tn.iit.service.ClientService;
import tn.iit.service.CompteService;

@Controller
@RequestMapping("/comptes")
public class CompteController {

	private final CompteService compteService;
	private final ClientService clientService;

	@Autowired
	public CompteController(CompteService compteService, ClientService clientService) {
		super();
		this.compteService = compteService;
		this.clientService = clientService;
	}

	@GetMapping("/all")
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("comptes", compteService.findAll()); // chargement de données pour la vue
		modelAndView.setViewName("comptes"); // la vue comptes.html

		return modelAndView;
	}

	

	@GetMapping("/all-json")
	@ResponseBody //retourne JSON (API Jackson)
	public List<Compte> findAllJson() {
		return compteService.findAll();
	}

	@PostMapping("/save")
	public String save(@RequestParam(name = "solde") float solde, @RequestParam(name = "cin") String cin) {
		Client client = clientService.findById(cin);
		Compte compte = new Compte(solde, client);
		compteService.save(compte);
		return "redirect:/comptes/all";
	}

	@GetMapping("/delete/{rib}")
	public String delete(@PathVariable(name = "rib") Long rib) {
		compteService.delete(rib);
		return "redirect:/comptes/all";
	}

	@PostMapping("/delete-ajax")
	@ResponseBody
	public void deleteAjax(@RequestParam(name = "rib") Long rib) {
		compteService.delete(rib);
	}

	@GetMapping("/edit/{rib}")
	public String edit(@PathVariable(name = "rib") Long rib, Model model) {
		Compte compte = compteService.findById(rib);
		model.addAttribute("compte", compte);
		return "edit-compte"; // va à la page edit-compte.html
	}

	@PostMapping(value = "/save1")
	public String save(@ModelAttribute Compte compte) {
		compteService.save(compte);
		return "redirect:/comptes/all";
	}

	@PostMapping(value = "/update")
	public String update(@ModelAttribute Compte compte) {
		compteService.update(compte);
		return "redirect:/comptes/all";
	}

}
