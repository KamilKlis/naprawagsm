package pl.naprawagsm;

import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import pl.naprawagsm.security.repository.User;
import pl.naprawagsm.security.repository.UserRepository;
import pl.naprawagsm.security.repository.UserRoles;

@SpringBootApplication
@ComponentScan
public class NaprawagsmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(NaprawagsmApplication.class, args);
//		UserRepository repo = ctx.getBean(UserRepository.class);
//		HashSet<UserRoles> hashSet = new HashSet<>();
//		hashSet.add(new UserRoles(1L,"admin"));
//		User user=new User(1L, "Edek", "{bcrypt}Polska",hashSet);
//		repo.save(user);
	}
}
