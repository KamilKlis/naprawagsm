package pl.naprawagsm.clientRepairs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RepairController {
	
	@RequestMapping("/kwit")
	public String serviceLabel() {
		return "serviceLabel";
	}

//	@RequestMapping("/Twoje Serwisy")
//	public String currentSevices(Model model) {
//		String currentRepair = priceList.getAllRepairs();
//		model.addAttribute("currentRepair", currentRepair);
//		return "currentRepairs";
//	}
	
}
