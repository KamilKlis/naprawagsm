package pl.naprawagsm.clientRepairs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.sym.Name;

import jakarta.websocket.server.PathParam;
import pl.naprawagsm.clientRepairs.model.RepairService;
import pl.naprawagsm.clientRepairs.repository.Repair;

@Controller
public class RepairController {
	
	RepairService repairService;
	
	public RepairController(RepairService repairService) {
		super();
		this.repairService = repairService;
	}

	
	@RequestMapping("/kwit")
	public String serviceLabel() {
		return "serviceLabel";
	}

	@RequestMapping("/twojeserwisy")
	public String currentRepairs(Model model,@RequestParam String modeltelefonu, @RequestParam String opisusterki,
								@RequestParam String stantelefonu, @RequestParam int maxkwotanaprawy,
								@RequestParam String imięinazwisko, @RequestParam String numertelefonu) {
		Repair repair =new Repair(modeltelefonu, stantelefonu, opisusterki, maxkwotanaprawy, imięinazwisko, numertelefonu);
		repairService.addRepair(repair);
		return "currentRepairs";
	}
	
}
