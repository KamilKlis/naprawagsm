package pl.naprawagsm.security.model;

import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import pl.naprawagsm.security.repository.User;
import pl.naprawagsm.security.repository.UserRepository;
import pl.naprawagsm.security.repository.UserRoles;

@Configuration
public class CustomDetailsService implements UserDetailsService{
	private UserRepository userRepository;
	private PasswordEncoder encoder;

	public CustomDetailsService(UserRepository userRepository, PasswordEncoder encoder) {
		super();
		this.userRepository = userRepository;
		this.encoder = encoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User finddedUser = userRepository.findByUsername(username).orElseThrow(
				() -> new NullPointerException());
		Set<UserRoles> roles = finddedUser.getRoles();
		String[] rolesArray = roles.stream().map(role->role.getUserRole()).toArray(String[]::new);
		String encodedPassword = encoder.encode(finddedUser.getPassword());
		UserBuilder builder = org.springframework.security.core.userdetails.User.builder();
		builder.username(username).password(encodedPassword)
		.roles(rolesArray);
		return builder.build();
	}

}
