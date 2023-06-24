package pl.naprawagsm.security.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String user_role;
	
	public UserRoles() {}
	
	public UserRoles(String userRole) {
		super();
		this.user_role = userRole;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserRole() {
		return user_role;
	}

	public void setUserRole(String userRole) {
		this.user_role = userRole;
	}

	@Override
	public String toString() {
		return "to jest roli [id=" + id + ", user_role=" + user_role + "]";
	}
	
	
}
