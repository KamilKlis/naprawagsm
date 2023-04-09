package pl.naprawagsm.clientRepairs.repository.dto;

import pl.naprawagsm.clientRepairs.repository.Repair;

public class RepairMapper {
	
	public static RepairDto map(Repair repair) {
		return new RepairDto(repair.getPhoneBrand(), repair.getPhoneModel(), repair.getPhoneCondition(),
										  repair.getFaultDescription(), repair.getMaxRepairAmount(), repair.getClientName(),
										  repair.getClientPhoneNumber());
	}

}
