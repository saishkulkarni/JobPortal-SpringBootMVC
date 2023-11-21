package org.jsp.jobportal.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

import org.jsp.jobportal.dto.Job;
import org.jsp.jobportal.dto.Recruiter;
import org.jsp.jobportal.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

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
	public String signup(Recruiter recruiter, ModelMap map) throws UnsupportedEncodingException, MessagingException {
		return recruiterService.signup(recruiter, map);
	}
	
	@GetMapping("/resend-otp/{id}")
	public String resendOtp(@PathVariable int id ,ModelMap map) throws UnsupportedEncodingException, MessagingException
	{
		return recruiterService.resendOtp(id,map);
	}

	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam int id, @RequestParam int otp, ModelMap map) {
		return recruiterService.verifyotp(id, otp, map);
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, ModelMap map, HttpSession session) {
		return recruiterService.login(email, password, map, session);
	}

	@GetMapping("/forgot-password")
	public String loadEnterEmail() {
		return "RecruiterEmail";
	}

	@PostMapping("/forgot-password")
	public String sendResetOtp(@RequestParam String email, ModelMap map) {
		return recruiterService.forgotPassword(email, map);
	}

	@PostMapping("/reset-password")
	public String resetPassword(@RequestParam String password, @RequestParam int id, @RequestParam int otp,
			ModelMap map) {
		return recruiterService.resetPassword(password, id, otp, map);
	}

	@GetMapping("/add-job")
	public String loadAddJob(HttpSession session, ModelMap map) {
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		if (recruiter == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return "AddJob";
	}

	@PostMapping("/add-job")
	public String addjob(Job job, HttpSession session, ModelMap map) {
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		if (recruiter == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return recruiterService.addJob(recruiter, job, session, map);
	}

	@GetMapping("/view-jobs")
	public String getJobs(HttpSession session, ModelMap map) {
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		if (recruiter == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return recruiterService.getJobs(recruiter, map);
	}

	@GetMapping("/back")
	public String back(HttpSession session, ModelMap map) {
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		if (recruiter == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return "RecruiterHome";
	}

	@GetMapping("/view-applications")
	public String viewApplications(HttpSession session, ModelMap map) {
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		if (recruiter == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return recruiterService.viewApplication(recruiter, map);
	}

	@PostMapping("/view-application")
	public String viewApplication(@RequestParam int id, HttpSession session, ModelMap map) {
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		if (recruiter == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return recruiterService.viewApplication(id, map);
	}

	@GetMapping("/schedule/{id}")
	public String loadSelectDate(@PathVariable int id, ModelMap map, HttpSession session) {
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		if (recruiter == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else {
			map.put("id", id);
			return "SelectInterviewDate";
		}
	}

	@PostMapping("/schedule")
	public String scheduleInterview(HttpSession session, ModelMap map, @RequestParam int id,
			@RequestParam LocalDateTime interviewDate) {
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		if (recruiter == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else {
			return recruiterService.scheduleInterview(id, interviewDate, map, session, recruiter);
		}
	}

	@GetMapping("/accept/{id}")
	public String acceptInterview(HttpSession session, ModelMap map, @PathVariable int id) {
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		if (recruiter == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else {
			return recruiterService.acceptInterview(id, map, session, recruiter);
		}
	}

	@GetMapping("/reject/{id}")
	public String rejectInterview(HttpSession session, ModelMap map, @PathVariable int id) {
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		if (recruiter == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else {
			return recruiterService.rejectInterview(id, map, session, recruiter);
		}
	}

	@GetMapping("/resume/{id}")
	public ResponseEntity<InputStreamResource> downloadResume(@PathVariable int id, HttpSession session, ModelMap map) {
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		if (recruiter == null) {
			map.put("fail", "Invalid Session");
			return null;
		} else {
			return recruiterService.downloadResume(id, map);
		}
	}
}
