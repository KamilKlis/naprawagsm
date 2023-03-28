package pl.naprawagsm.clientRepairs.model;

import org.springframework.stereotype.Service;

import pl.naprawagsm.clientRepairs.repository.RepairRepository;

@Service
public class RepairService {
	
	private RepairRepository repairRepository;

	public RepairService(RepairRepository repairRepository) {
		super();
		this.repairRepository = repairRepository;
	}

	public RepairRepository getRepairRepository() {
		return repairRepository;
	}

	public void setRepairRepository(RepairRepository repairRepository) {
		this.repairRepository = repairRepository;
	}
	
}
