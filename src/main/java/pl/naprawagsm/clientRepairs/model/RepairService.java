package pl.naprawagsm.clientRepairs.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.naprawagsm.clientRepairs.repository.Repair;
import pl.naprawagsm.clientRepairs.repository.RepairRepository;
import pl.naprawagsm.clientRepairs.repository.dto.RepairDto;
import pl.naprawagsm.clientRepairs.repository.dto.RepairMapper;
import pl.naprawagsm.security.repository.User;
import pl.naprawagsm.security.repository.UserRepository;

@Service
public class RepairService {
	
	private RepairMapper repairMapper;
	private RepairRepository repairRepository;
	private UserRepository userRepository;
	
	public RepairService(RepairMapper repairMapper, RepairRepository repairRepository, UserRepository userRepository) {
		super();
		this.repairMapper = repairMapper;
		this.repairRepository = repairRepository;
		this.userRepository = userRepository;
	}

	public List<RepairDto> getRepairsOfCurrentUser(){
		List<RepairDto> list=new ArrayList<>();
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		User finddedUsername = userRepository.findByUsername(user).orElseThrow(
				() -> new UsernameNotFoundException(user));
		Long userId = finddedUsername.getId();
		List<Repair> finddedRepairsList = repairRepository.findAllByUser_id(userId);
		for(Repair repair:finddedRepairsList) {
			if(repair.getUser().getId().equals(userId)) {
				list.add(repairMapper.map(repair));
			}
		}
		return list;
	}
	
	public RepairDto getRepairOfCurrentUserById(Long id) {
		return repairRepository.findById(id).map(repair->repairMapper.map(repair))
				.orElseThrow(()->new IllegalArgumentException());
	}

	public List<RepairDto> getAllRepairs(){
		List<RepairDto> list=new ArrayList<>();
		Iterator<Repair> repairs = repairRepository.findAll().iterator();
		while(repairs.hasNext()) {
			RepairDto repairDto = repairMapper.map(repairs.next()) ;
			list.add(repairDto);
		}
		return list;
	}
	
	public boolean addRepair(RepairDto repairDto) {
		Repair repair = repairMapper.map(repairDto);
		List<RepairDto> allRepairs = getAllRepairs();
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		User finddedUsername = userRepository.findByUsername(user).orElseThrow(
				() -> new UsernameNotFoundException(user));
		finddedUsername.getRepairs().add(repair);
		if(!allRepairs.contains(repairDto)) {
			repair.setUser(finddedUsername);
			repairRepository.save(repair);
			userRepository.save(finddedUsername);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Optional<RepairDto> updateRepair(Long id, RepairDto repairDto) {
		if(repairRepository.existsById(id)) {
			Repair repairToSave = repairMapper.map(repairDto);
			repairToSave.setId(id);
			repairRepository.save(repairToSave);
			return Optional.of(repairDto);
		}else {
			return Optional.empty();
		}
		
		/*
		 * Optional<Repair> finddedRepair = repairRepository.findById(id); Repair
		 * repairToSave = repairMapper.map(repairDto);
		 * repairToSave.setId(finddedRepair.get().getId());
		 * finddedRepair.map(repair->repairRepository.save(repairToSave))
		 * .orElseThrow(()->new IllegalArgumentException()); return repairDto;
		 */
	}
	
	public void deleteRepair(Long id) {
		repairRepository.deleteById(id);
	}
}
