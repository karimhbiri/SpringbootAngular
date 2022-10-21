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
@RequestMapping("/clients")
public class ClientController {

	private final ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@GetMapping("/all")
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("clients", clientService.findAll()); // chargement de données pour la vue
		modelAndView.setViewName("clients"); // la vue comptes.html

		return modelAndView;
	}

	@GetMapping("/all-json")
	@ResponseBody //retourne JSON (API Jackson)
	public List<Client> findAllJson() {
		return clientService.findAll();
	}

	@PostMapping("/save")
	public String save(@RequestParam(name = "cin") String cin,
			@RequestParam(name = "nom") String nom,
			@RequestParam(name = "prenom") String prenom) {
		
		Client client = new Client(cin, nom,prenom);
		clientService.save(client);
		return "redirect:/clients/all";
	}

	@GetMapping("/delete/{cin}")
	public String delete(@PathVariable(name = "cin") String cin) {
		clientService.delete(cin);
		return "redirect:/clients/all";
	}

	@PostMapping("/delete-ajax")
	@ResponseBody
	public void deleteAjax(@RequestParam(name = "cin") String cin) {
		clientService.delete(cin);
	}

	@GetMapping("/edit/{cin}")
	public String edit(@PathVariable(name = "cin") String cin, Model model) {
		Client client = clientService.findById(cin);
		model.addAttribute("client", client);
		return "edit-client"; // va à la page edit-compte.html
	}

	@PostMapping(value = "/save1")
	public String save(@ModelAttribute Client client) {
		clientService.save(client);
		return "redirect:/clients/all";
	}

	@PostMapping(value = "/update")
	public String update(@ModelAttribute Client client) {
		clientService.update(client);
		return "redirect:/clients/all";
	}

}
