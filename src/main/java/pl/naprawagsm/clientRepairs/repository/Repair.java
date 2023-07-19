package pl.naprawagsm.clientRepairs.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import pl.naprawagsm.security.repository.User;
import pl.naprawagsm.validation.MaxRepairAmountIsNumber;
import pl.naprawagsm.validation.PhoneNumber;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Repair {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phoneBrand;
	@NotBlank
	private String phoneModel;
	@NotBlank
	private String phoneCondition;
	@NotBlank
	private String faultDescription;
	@Min(value = 0L)
	private int maxRepairAmount;
	@NotBlank
	private String clientName;
	@PhoneNumber
	private String clientPhoneNumber;
	@ManyToOne
	private User user;
	
	
	public Repair(String phoneBrand, String phoneModel, String phoneCondition, String faultDescription, int maxRepairAmount,
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
	
	public Repair() {}
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "phoneModel=" + phoneModel + ", phoneCondition=" + phoneCondition + ", faultDescription="
				+ faultDescription + ", maxAmount=" + maxRepairAmount + ", clientName=" + clientName + ", clientPhoneNumber="
				+ clientPhoneNumber;
	}
}
