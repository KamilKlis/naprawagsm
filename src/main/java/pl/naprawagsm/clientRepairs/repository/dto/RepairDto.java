package pl.naprawagsm.clientRepairs.repository.dto;

import java.util.Objects;

public class RepairDto {
	
	private String phoneBrand;
	private String phoneModel;
	private String phoneCondition;
	private String faultDescription;
	private int maxRepairAmount;
	private String clientName;
	private String clientPhoneNumber;
	
	public RepairDto(String phoneBrand, String phoneModel, String phoneCondition, String faultDescription, int maxRepairAmount,
			String clientName, String clientPhoneNumber) {
		super();
		this.phoneBrand = phoneBrand;
		this.phoneModel = phoneModel;
		this.phoneCondition = phoneCondition;
		this.faultDescription = faultDescription;
		this.maxRepairAmount = maxRepairAmount;
		this.clientName = clientName;
		this.clientPhoneNumber = clientPhoneNumber;
	}
	
	public RepairDto() {}
	
	public String getPhoneBrand() {
		return phoneBrand;
	}

	public void setPhoneBrand(String phoneBrand) {
		this.phoneBrand = phoneBrand;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(clientName, clientPhoneNumber, faultDescription, maxRepairAmount, phoneBrand,
				phoneCondition, phoneModel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepairDto other = (RepairDto) obj;
		return Objects.equals(clientName, other.clientName)
				&& Objects.equals(clientPhoneNumber, other.clientPhoneNumber)
				&& Objects.equals(faultDescription, other.faultDescription) && maxRepairAmount == other.maxRepairAmount
				&& Objects.equals(phoneBrand, other.phoneBrand) && Objects.equals(phoneCondition, other.phoneCondition)
				&& Objects.equals(phoneModel, other.phoneModel);
	}
	
}