package pl.naprawagsm;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import pl.naprawagsm.security.repository.User;
import pl.naprawagsm.security.repository.UserRepository;
import pl.naprawagsm.security.repository.UserRoles;
import pl.naprawagsm.security.repository.UserRolesRepository;

@SpringBootApplication
@ComponentScan
public class NaprawagsmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(NaprawagsmApplication.class, args);
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		UserRolesRepository roleRepository = ctx.getBean(UserRolesRepository.class);
//		roleRepository.save(new UserRoles("littleUser"));
//		User user = new User("dawid7", "goliat2", Set.of(new UserRoles("user")));
//		userRepository.save(user);
	}
}
