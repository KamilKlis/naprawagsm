package pl.naprawagsm.clientRepairs.repository.dto;

import org.springframework.stereotype.Service;

import pl.naprawagsm.clientRepairs.repository.Repair;
@Service
public class RepairMapper {
	
	public RepairDto map(Repair repair) {
		return new RepairDto(repair.getId(),repair.getPhoneBrand(), repair.getPhoneModel(), repair.getPhoneCondition(),
										  repair.getFaultDescription(), repair.getMaxRepairAmount(), repair.getClientName(),
										  repair.getClientPhoneNumber());
	}
	
	public Repair map(RepairDto repairDto) {
		return new Repair(repairDto.getPhoneBrand(), repairDto.getPhoneModel(), repairDto.getPhoneCondition(),
				repairDto.getFaultDescription(), repairDto.getMaxRepairAmount(), repairDto.getClientName(),
				repairDto.getClientPhoneNumber());
	}
}
