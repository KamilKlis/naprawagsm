package pl.naprawagsm.clientRepairs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.naprawagsm.clientRepairs.model.RepairService;
import pl.naprawagsm.clientRepairs.repository.Repair;

@Controller
public class RepairController {
	
	private RepairService repairService;
	
	public RepairController(RepairService repairService) {
		super();
		this.repairService = repairService;
	}

	
	@RequestMapping("/kwit")
	public String serviceLabel() {
		return "serviceLabel";
	}

	@PostMapping("/twojeserwisy")
	public String currentRepairs(Model model,@RequestParam String markatelefonu, @RequestParam String modeltelefonu, @RequestParam String opisusterki,
								@RequestParam String stantelefonu, @RequestParam int maxkwotanaprawy,
								@RequestParam String imięinazwisko, @RequestParam String numertelefonu) {
		Repair repair =new Repair(markatelefonu, modeltelefonu, stantelefonu, opisusterki, maxkwotanaprawy, imięinazwisko, numertelefonu);
		boolean addRepair = repairService.addRepair(repair);
		if(addRepair) {
			return "redirect:serwis?model="+modeltelefonu;
		}
		else {
			return "redirect:duplicate";
		}
	}
	@GetMapping("/serwis")
	public String toRepair(Model model) {
		model.addAttribute("repairList", repairService.getAllRepairs());
		return "currentRepairs";
	}
	
	@GetMapping("/duplicate")
	public String duplicate(Model model) {
		model.addAttribute("repairList", repairService.getAllRepairs());
		model.addAttribute("addedRepairIsAlreadyInDatabase", true);
		return "currentRepairs";
	}
	
	
}
