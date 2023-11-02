package org.jsp.jobportal.controller;

import java.io.UnsupportedEncodingException;

import org.jsp.jobportal.dto.Recruiter;
import org.jsp.jobportal.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.mail.MessagingException;

@Controller
@RequestMapping("/recruiter")
public class RecruiterController {
	
	@Autowired
	RecruiterService recruiterService;
	
	@GetMapping("/login")
	public String loadLogin() {
		return "RecruiterLogin";
	}

	@GetMapping("/signup")
	public String loadSignup() {
		return "RecruiterSignup";
	}
	
	@PostMapping("/signup")
	public String signup(Recruiter recruiter,ModelMap map) throws UnsupportedEncodingException, MessagingException
	{
		return recruiterService.signup(recruiter,map);
	}
	
	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam int id,@RequestParam int otp,ModelMap map)
	{
		return recruiterService.verifyotp(id,otp,map);
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String email,@RequestParam String password,ModelMap map)
	{
		return recruiterService.login(email,password,map);
	}
}
