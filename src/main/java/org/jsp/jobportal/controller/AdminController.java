package org.jsp.jobportal.controller;

import org.jsp.jobportal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/login")
	public String loadLogin() {
		return "AdminLogin";
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, ModelMap map, HttpSession session) {
		return adminService.login(email, password, map, session);
	}

	@GetMapping("/view-jobs")
	public String fetchAllJobs(ModelMap map, HttpSession session) {
		String admin = (String) session.getAttribute("admin");
		if (admin == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return adminService.fetchAllJobs(map);
	}

	@GetMapping("/back")
	public String goBack(ModelMap map, HttpSession session) {
		String admin = (String) session.getAttribute("admin");
		if (admin == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return "AdminHome";
	}
	
	@GetMapping("/change-status/{id}")
	public String changeStatus(@PathVariable int id,ModelMap map,HttpSession session)
	{
		String admin = (String) session.getAttribute("admin");
		if (admin == null) {
			map.put("fail", "Invalid Session");
			return "Home";
		} else
			return adminService.changeStatus(id,map,session);
	}

}
