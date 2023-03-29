package pl.naprawagsm.clientRepairs.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.naprawagsm.clientRepairs.repository.Repair;
import pl.naprawagsm.clientRepairs.repository.RepairRepository;

@Service
public class RepairService {
	
	private RepairRepository repo;

	public RepairService(RepairRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Repair> getaAllRepairs(){
		List<Repair> list=new ArrayList<Repair>();
		Iterator<Repair> repairs = repo.findAll().iterator();
		while(repairs.hasNext()) {
			list.add(repairs.next());
		}
		return list;
	}
	
	public void addRepair(Repair repair) {
		repo.save(repair);
	}
	
}
