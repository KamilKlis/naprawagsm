package pl.naprawagsm.clientRepairs.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Repair {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phoneModel;
	private String phoneCondition;
	private String faultDescription;
	private int maxRepairAmount;
	private String clientName;
	private String clientPhoneNumber;
	
	
	public Repair(String phoneModel, String phoneCondition, String faultDescription, int maxRepairAmount,
			String clientName, String clientPhoneNumber) {
		super();
		this.phoneModel = phoneModel;
		this.phoneCondition = phoneCondition;
		this.faultDescription = faultDescription;
		this.maxRepairAmount = maxRepairAmount;
		this.clientName = clientName;
		this.clientPhoneNumber = clientPhoneNumber;
	}
	
	public Repair() {}

	public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	public String getPhoneCondition() {
		return phoneCondition;
	}

	public void setPhoneCondition(String phoneCondition) {
		this.phoneCondition = phoneCondition;
	}

	public String getFaultDescription() {
		return faultDescription;
	}

	public void setFaultDescription(String faultDescription) {
		this.faultDescription = faultDescription;
	}

	public int getMaxRepairAmount() {
		return maxRepairAmount;
	}

	public void setMaxRepairAmount(int maxRepairAmount) {
		this.maxRepairAmount = maxRepairAmount;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhoneNumber() {
		return clientPhoneNumber;
	}

	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}

	@Override
	public String toString() {
		return "phoneModel=" + phoneModel + ", phoneCondition=" + phoneCondition + ", faultDescription="
				+ faultDescription + ", maxAmount=" + maxRepairAmount + ", clientName=" + clientName + ", clientPhoneNumber="
				+ clientPhoneNumber;
	}
}
