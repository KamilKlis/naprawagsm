package pl.naprawagsm.clientRepairs.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.naprawagsm.clientRepairs.repository.Repair;
import pl.naprawagsm.clientRepairs.repository.RepairRepository;
import pl.naprawagsm.clientRepairs.repository.dto.RepairDto;
import pl.naprawagsm.clientRepairs.repository.dto.RepairMapper;

@Service
public class RepairService {
	
	private RepairRepository repo;

	public RepairService(RepairRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Repair> getAllRepairs(){
		List<Repair> list=new ArrayList<Repair>();
		Iterator<Repair> repairs = repo.findAll().iterator();
		while(repairs.hasNext()) {
			list.add(repairs.next());
		}
		return list;
	}
	
	public boolean addRepair(Repair repair) {
		List<RepairDto> allRepairs = getAllRepairs().stream().map(RepairMapper::map).toList();
		if(!allRepairs.contains(RepairMapper.map(repair))) {
			repo.save(repair);
			return true;
		}
		else {
			System.out.println("Notatka jest juz zapisana");
			return false;
		}
	}
	
//	public boolean addRepair(Repair repair) {
//		List<Repair> allRepairs = getAllRepairs();
//		if(!allRepairs.contains(repair)) {
//			repo.save(repair);
//			return true;
//		}
//		else {
//			System.out.println("Notatka jest juz zapisana");
//			return false;
//		}
//	}
}
