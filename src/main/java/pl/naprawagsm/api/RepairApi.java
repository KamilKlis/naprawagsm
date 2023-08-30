package pl.naprawagsm.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pl.naprawagsm.clientRepairs.model.RepairService;
import pl.naprawagsm.clientRepairs.repository.dto.RepairDto;

@RestController
@RequestMapping("/api/repairs")
public class RepairApi {
	private RepairService repairService;
	
	public RepairApi(RepairService repairService) {
		super();
		this.repairService = repairService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RepairDto> getAllRepairs() {
		List<RepairDto> repairsOfCurrentUser = repairService.getRepairsOfCurrentUser();
		return repairsOfCurrentUser;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RepairDto> getRepairById(@PathVariable Long id) {
		Optional<RepairDto> finddedRepair = repairService.getRepairOfCurrentUserById(id);
		return finddedRepair.map(repair->ResponseEntity.ok(repair))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping()
	public ResponseEntity<RepairDto> addRepair(@RequestBody RepairDto repair) {
		repairService.addRepair(repair);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}").buildAndExpand(repair.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RepairDto> updateRepair(@PathVariable Long id, @RequestBody RepairDto repair) {
		return repairService.updateRepair(id,repair).map(mappedRepair->ResponseEntity.ok(mappedRepair))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRepair(@PathVariable Long id) {
		return repairService.deleteRepair(id).map(repair->ResponseEntity.noContent().build())
			.orElse(ResponseEntity.notFound().build());
	}
}
