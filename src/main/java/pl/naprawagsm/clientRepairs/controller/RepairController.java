package pl.naprawagsm.clientRepairs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import pl.naprawagsm.clientRepairs.model.RepairService;
import pl.naprawagsm.clientRepairs.repository.dto.RepairDto;

@Controller
public class RepairController {
	
	private RepairService repairService;
	
	public RepairController(RepairService repairService) {
		super();
		this.repairService = repairService;
	}
	
	@RequestMapping("/kwit")
	public String serviceLabel(Model model) {
		model.addAttribute("repair", new RepairDto());
		return "serviceLabel";
	}

	@PostMapping("/twojeserwisy")
	public String currentRepairs(@Valid @ModelAttribute("repair") RepairDto repair,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "serviceLabel";
		}else {
			boolean addRepair = repairService.addRepair(repair);
			if(addRepair) {
				return "redirect:serwis?model=" + repair.getPhoneModel();
			}
			else {
				return "redirect:duplicate";
			}
		}	
	}
	
	@GetMapping("/serwis")
	public String toRepair(Model model) {
		model.addAttribute("repairList", repairService.getRepairsOfCurrentUser());
		return "currentRepairs";
	}
	
	@GetMapping("/duplicate")
	public String duplicate(Model model) {
		model.addAttribute("repairList", repairService.getRepairsOfCurrentUser());
		model.addAttribute("addedRepairIsAlreadyInDatabase", true);
		return "currentRepairs";
	}
	
}
