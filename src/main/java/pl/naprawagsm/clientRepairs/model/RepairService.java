package pl.naprawagsm.clientRepairs.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.naprawagsm.clientRepairs.repository.Repair;
import pl.naprawagsm.clientRepairs.repository.RepairRepository;
import pl.naprawagsm.clientRepairs.repository.dto.RepairDto;
import pl.naprawagsm.clientRepairs.repository.dto.RepairMapper;
import pl.naprawagsm.security.repository.User;
import pl.naprawagsm.security.repository.UserRepository;

@Service
public class RepairService {
	
	private RepairRepository repairRepository;
	private UserRepository userRepository;

	public RepairService(RepairRepository repairRepository, UserRepository userRepository) {
		super();
		this.repairRepository = repairRepository;
		this.userRepository = userRepository;
	}
	
	public List<Repair> getRepairsOfCurrentUser(){
		List<Repair> list=new ArrayList<Repair>();
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		User finddedUsername = userRepository.findByUsername(user).orElseThrow(
				() -> new UsernameNotFoundException(user));
		Long userId = finddedUsername.getId();
		List<Repair> finddedRepairsList = repairRepository.findAllByUser_id(userId);
		for(Repair repair:finddedRepairsList) {
			if(repair.getUser().getId().equals(userId)) {
				list.add(repair);
			}
		}
		return list;
	}

	public List<Repair> getAllRepairs(){
		List<Repair> list=new ArrayList<Repair>();
		Iterator<Repair> repairs = repairRepository.findAll().iterator();
		while(repairs.hasNext()) {
			list.add(repairs.next());
		}
		return list;
	}
	
	public boolean addRepair(Repair repair) {
		List<RepairDto> allRepairs = getAllRepairs().stream().map(RepairMapper::map).toList();
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		User finddedUsername = userRepository.findByUsername(user).orElseThrow(
				() -> new UsernameNotFoundException(user));
		finddedUsername.getRepairs().add(repair);
		if(!allRepairs.contains(RepairMapper.map(repair))) {
			repair.setUser(finddedUsername);
			repairRepository.save(repair);
			userRepository.save(finddedUsername);
			return true;
		}
		else {
			System.out.println("Notatka jest juz zapisana");
			return false;
		}
	}
}
