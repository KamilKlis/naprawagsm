package pl.naprawagsm.clientRepairs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.naprawagsm.clientRepairs.repository.Repair;

@Controller
public class RepairController {
	
	@RequestMapping("/kwit")
	public String serviceLabel() {
		return "serviceLabel";
	}

	@RequestMapping("/twojeserwisy")
	public String currentRepairs(Model model) {
		model.addAttribute("repair", new Repair());
		return "currentRepairs";
	}
	
}
