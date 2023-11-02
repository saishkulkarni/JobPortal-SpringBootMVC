package org.jsp.jobportal.controller;

import java.io.IOException;

import org.jsp.jobportal.dto.User;
import org.jsp.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String loadLogin() {
		return "UserLogin";
	}

	@GetMapping("/signup")
	public String loadSignup() {
		return "UserSignup";
	}

	@PostMapping("/signup")
	public String signup(User user, @RequestParam MultipartFile doc, ModelMap map) throws IOException, MessagingException {
		return userService.signup(user, doc, map);
	}
	
	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam int id,@RequestParam int otp,ModelMap map)
	{
		return userService.verifyotp(id,otp,map);
	}
}
