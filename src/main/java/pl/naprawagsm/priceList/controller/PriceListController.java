package pl.naprawagsm.priceList.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.naprawagsm.priceList.model.PricelistService;
import pl.naprawagsm.priceList.repository.PriceList;

@Controller
public class PriceListController {

	private PricelistService priceList;
	private List<PriceList> repairPrices;
	
	public PriceListController(PricelistService priceList) {
		super();
		this.priceList = priceList;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		repairPrices = priceList.getAllPrices();
		model.addAttribute("repairPrices", repairPrices);
		model.addAttribute("example", "example");
		return "index";
	}
	
}
