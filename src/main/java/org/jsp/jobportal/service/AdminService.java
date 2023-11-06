package org.jsp.jobportal.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {

	public String login(String email, String password, ModelMap map, HttpSession session) {
		if (email.equals("admin")) {
			if (password.equals("admin")) {
				map.put("pass", "Login Success");
				session.setAttribute("admin", "admin");
				return "AdminHome";
			} else {
				map.put("fail", "Invalid Password");
				return "AdminLogin";
			}
		} else {
			map.put("fail", "Invalid Email");
			return "AdminLogin";
		}
	}

}
