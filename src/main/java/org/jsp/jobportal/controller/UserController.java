package org.jsp.jobportal.controller;

import org.jsp.jobportal.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	@GetMapping("/login")
	public String loadLogin() {
		return "UserLogin";
	}

	@GetMapping("/signup")
	public String loadSignup() {
		return "UserSignup";
	}

	@PostMapping("/signup")
	@ResponseBody
	public User signup(User user) {
		return user;
	}
}
