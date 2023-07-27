package pl.naprawagsm.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.naprawagsm.security.model.UserService;
import pl.naprawagsm.security.repository.User;

@Controller
public class SecurityController {
	private UserService userService;
	
	public SecurityController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/registerSuccess")
	public String registerSuccess(@ModelAttribute User user){
		userService.saveUser(user);
		return "registerSuccess";
	}
	
	@RequestMapping("/bye")
	public String logout() {
		return "logout";
	}

}
