package org.jsp.jobportal.service;

import java.util.List;

import org.jsp.jobportal.dao.JobDao;
import org.jsp.jobportal.dto.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {

	@Autowired
	JobDao jobDao;
	
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

	public String fetchAllJobs(ModelMap map) {
		List<Job> jobs=jobDao.fetchAll();
		if(jobs.isEmpty())
		{
			map.put("fail", "No Job Posted Yet");
			return "AdminHome";
		}
		else {
			map.put("jobs", jobs);
			return "ViewAdminJobs";
		}
	}

	public String changeStatus(int id, ModelMap map, HttpSession session) {
		Job job=jobDao.findById(id);
		if(job==null)
		{
			map.put("fail", "Something went wrong");
			return "Home";
		}
		else {
			if(job.isApproved())
				job.setApproved(false);
			else
				job.setApproved(true);
			
			jobDao.save(job);
			
			map.put("pass", "Status Updated");
			return fetchAllJobs(map);
		}
	}

}
