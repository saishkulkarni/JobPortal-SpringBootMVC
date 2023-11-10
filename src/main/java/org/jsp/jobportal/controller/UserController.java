package org.jsp.jobportal.controller;

import java.io.IOException;

import org.jsp.jobportal.dto.User;
import org.jsp.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.razorpay.RazorpayException;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

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
	public String signup(User user, @RequestParam MultipartFile doc, ModelMap map)
			throws IOException, MessagingException {
		return userService.signup(user, doc, map);
	}

	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam int id, @RequestParam int otp, ModelMap map) {
		return userService.verifyotp(id, otp, map);
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, ModelMap map, HttpSession session) {
		return userService.login(email, password, map, session);
	}

	@GetMapping("/forgot-password")
	public String loadEnterEmail() {
		return "UserEmail";
	}

	@PostMapping("/forgot-password")
	public String sendResetOtp(@RequestParam String email, ModelMap map) {
		return userService.forgotPassword(email, map);
	}

	@PostMapping("/reset-password")
	public String resetPassword(@RequestParam String password, @RequestParam int id, @RequestParam int otp,
			ModelMap map) {
		return userService.resetPassword(password, id, otp, map);
	}

	@GetMapping("/view-jobs")
	public String getJobs(HttpSession session, ModelMap map) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return userService.getJobs(map);
	}

	@GetMapping("/back")
	public String back(HttpSession session, ModelMap map) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return "UserHome";
	}

	@GetMapping("/apply-job/{id}")
	public String applyjob(@PathVariable int id, HttpSession session, ModelMap map) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return userService.applyJob(id, user, map,session);
	}

	@GetMapping("/buy-prime")
	public String buyPrime(HttpSession session, ModelMap map) throws RazorpayException {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return userService.buyPrime(user, map);
	}

	@PostMapping("/payment/{id}")
	public String paymentDone(@PathVariable int id,@RequestParam String razorpay_payment_id, ModelMap map, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return userService.paymentDone(id,user,session,razorpay_payment_id, map);
	}

}
