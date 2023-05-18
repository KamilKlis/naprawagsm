package pl.naprawagsm.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	public SecurityConfig() {
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(requests->requests
				.requestMatchers("/").permitAll()
				.requestMatchers(HttpMethod.POST, "/logout").permitAll()
				.anyRequest().authenticated());
		http.formLogin(form->form
				.loginPage("/login").permitAll());
		http.logout(logout->logout
				.logoutSuccessUrl("/bye").permitAll());
		http.csrf().disable();
		return http.build();
	}
}
