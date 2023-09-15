package pl.naprawagsm.api;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import pl.naprawagsm.clientRepairs.model.RepairService;
import pl.naprawagsm.clientRepairs.repository.dto.RepairDto;

@RestController
@RequestMapping(path = "/api/repairs",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
public class RepairApi {
	private RepairService repairService;
	
	public RepairApi(RepairService repairService) {
		super();
		this.repairService = repairService;
	}

	@GetMapping
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
	public ResponseEntity<RepairDto> addRepair(@Valid @RequestBody RepairDto repair) {
		repairService.addRepair(repair);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}").buildAndExpand(repair.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
		return ex.getBindingResult().getFieldErrors()
			.stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
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
