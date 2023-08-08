package pl.naprawagsm.api;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pl.naprawagsm.clientRepairs.model.RepairService;
import pl.naprawagsm.clientRepairs.repository.Repair;
import pl.naprawagsm.clientRepairs.repository.RepairRepository;
import pl.naprawagsm.clientRepairs.repository.dto.RepairDto;
import pl.naprawagsm.clientRepairs.repository.dto.RepairMapper;
import pl.naprawagsm.security.repository.User;
import pl.naprawagsm.security.repository.UserRepository;


@RestController
public class RepairApi {
	private RepairService repairService;
	
	public RepairApi(RepairRepository repository, RepairService repairService) {
		super();
		this.repairService = repairService;
	}

	@GetMapping(path = "/api/repairs", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<RepairDto> getAllRepairs() {
		List<Repair> repairsOfCurrentUser = repairService.getRepairsOfCurrentUser();
		List<RepairDto> repatDtoList = repairsOfCurrentUser.stream().map(RepairMapper::map).toList();
		return repatDtoList;
	}
	
	@GetMapping("/api/repairs/{id}")
	public RepairDto getRepairById(@PathVariable Long id) {
		Repair repair = repairService.getRepairOfCurrentUserById(id);
		return RepairMapper.map(repair);
	}
}
