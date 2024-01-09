package pl.naprawagsm.security.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

	public SecurityConfig() {
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(requests->requests
				.requestMatchers("/img/**","/styles/**","/javascripts/**").permitAll()
				.requestMatchers("/","/register","/registerSuccess","/login").permitAll()
				.requestMatchers(HttpMethod.POST, "/logout").permitAll()
				.anyRequest().hasAnyRole("ADMIN","USER"));
		http.formLogin(form->form
				.loginPage("/login").permitAll());
		http.logout(logout->logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", HttpMethod.GET.name()))
				.logoutSuccessUrl("/bye").permitAll());
		http.headers().frameOptions().sameOrigin();
		return http.build();
	}
	
	@Bean
	public static PasswordEncoder encoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
