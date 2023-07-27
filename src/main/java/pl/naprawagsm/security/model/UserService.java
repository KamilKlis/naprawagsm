package pl.naprawagsm.security.model;

import java.util.Set;

import org.springframework.stereotype.Service;

import pl.naprawagsm.security.repository.User;
import pl.naprawagsm.security.repository.UserRepository;
import pl.naprawagsm.security.repository.UserRoles;
import pl.naprawagsm.security.repository.UserRolesRepository;

@Service
public class UserService {
	private UserRepository repository;
	private UserRolesRepository roles;
	
	public UserService(UserRepository repository, UserRolesRepository roles) {
		super();
		this.repository = repository;
		this.roles = roles;
	}



	public void saveUser(User user) {
		
		UserRoles role=roles.findById(2L).get();
		Set<UserRoles> rolesSet = Set.of(role);
		user.setRoles(rolesSet);
		repository.save(user);
	}
	
}
