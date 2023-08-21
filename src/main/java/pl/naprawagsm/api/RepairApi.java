package pl.naprawagsm.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.naprawagsm.clientRepairs.model.RepairService;
import pl.naprawagsm.clientRepairs.repository.Repair;
import pl.naprawagsm.clientRepairs.repository.RepairRepository;
import pl.naprawagsm.clientRepairs.repository.dto.RepairDto;

@RestController
public class RepairApi {
	private RepairService repairService;
	
	public RepairApi(RepairRepository repository, RepairService repairService) {
		super();
		this.repairService = repairService;
	}

	@GetMapping(path = "/api/repairs", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RepairDto> getAllRepairs() {
		List<RepairDto> repairsOfCurrentUser = repairService.getRepairsOfCurrentUser();
		return repairsOfCurrentUser;
	}
	
	@GetMapping("/api/repairs/{id}")
	public RepairDto getRepairById(@PathVariable Long id) {
		RepairDto repair = repairService.getRepairOfCurrentUserById(id);
		return repair;
	}
	
	@PostMapping("/api/repairs")
	public RepairDto addRepair(@RequestBody RepairDto repair) {
		repairService.addRepair(repair);
		return repair;
	}
	
	@PutMapping("/api/repairs/{id}")
	public RepairDto updateRepair(@PathVariable Long id, @RequestBody RepairDto repair) {
		return repairService.updateRepair(id,repair).orElseThrow(()->new IllegalArgumentException());
	}
	
	@DeleteMapping("/api/repairs/{id}")
	public void deleteRepair(@PathVariable Long id) {
		repairService.deleteRepair(id);
	}
}
