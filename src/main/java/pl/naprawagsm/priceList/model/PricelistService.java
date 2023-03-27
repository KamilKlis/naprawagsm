package pl.naprawagsm.priceList.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.naprawagsm.priceList.repository.PriceList;
import pl.naprawagsm.priceList.repository.PriceListRepository;

@Component
public class PricelistService {
	
	private PriceListRepository repo;
	
	public PricelistService(PriceListRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<PriceList> getAllPrices() {
		List<PriceList> list=new ArrayList<>();
		Iterator<PriceList> repairs = repo.findAll().iterator();
		while(repairs.hasNext()) {
			list.add(repairs.next());
		}
		return list;
	}
}
