package org.jsp.jobportal.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jsp.jobportal.dao.RecruiterDao;
import org.jsp.jobportal.dto.Job;
import org.jsp.jobportal.dto.Recruiter;
import org.jsp.jobportal.helper.EmailLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

@Service
public class RecruiterService {

	@Autowired
	RecruiterDao recruiterDao;

	@Autowired
	EmailLogic emailLogic;

	public String signup(Recruiter recruiter, ModelMap map) throws UnsupportedEncodingException, MessagingException {
		Recruiter recruiter1 = recruiterDao.findByEmail(recruiter.getEmail());
		Recruiter recruiter2 = recruiterDao.findByMobile(recruiter.getMobile());
		if (recruiter1 == null && recruiter2 == null) {
			int otp = new Random().nextInt(100000, 999999);
			recruiter.setOtp(otp);
			// emailLogic.sendOtp(recruiter);
			recruiterDao.save(recruiter);
			map.put("pass", "Otp Sent");
			map.put("id", recruiter.getId());
			return "RecruiterOtp";
		} else {
			map.put("fail", "Email or Mobile is Repeated");
			return "RecruiterSignup";
		}
	}

	public String verifyotp(int id, int otp, ModelMap map) {
		Recruiter recruiter = recruiterDao.findById(id);
		if (recruiter == null) {
			map.put("fail", "Invalid ID");
			return "Home";
		} else {
			if (recruiter.getOtp() == otp) {
				recruiter.setVerfied(true);
				recruiterDao.save(recruiter);
				map.put("pass", "Account verified Success");
				return "RecruiterLogin";
			} else {
				map.put("fail", "Invalid OTP");
				map.put("id", id);
				return "RecruiterOtp";
			}
		}
	}

	public String login(String email, String password, ModelMap map, HttpSession session) {
		Recruiter recruiter = recruiterDao.findByEmail(email);
		if (recruiter == null) {
			map.put("fail", "Invalid Email");
			return "RecruiterLogin";
		} else {
			if (recruiter.getPassword().equals(password)) {
				if (recruiter.isVerfied()) {
					session.setAttribute("recruiter", recruiter);
					map.put("pass", "Login Succcess");
					return "RecruiterHome";
				} else {
					map.put("fail", "Account Not Verified");
					return "RecruiterLogin";
				}
			} else {
				map.put("fail", "Invalid Password");
				return "RecruiterLogin";
			}
		}
	}

	public String forgotPassword(String email, ModelMap map) {
		Recruiter recruiter = recruiterDao.findByEmail(email);
		if (recruiter == null) {
			map.put("fail", "Email Doesnot Exist");
			return "RecruiterEmail";
		} else {
			int otp = new Random().nextInt(100000, 999999);
			recruiter.setOtp(otp);
			// emailLogic.sendOtp(recruiter);
			recruiterDao.save(recruiter);
			map.put("pass", "Otp Sent");
			map.put("id", recruiter.getId());
			return "RecruiterPassword";
		}
	}

	public String resetPassword(String password, int id, int otp, ModelMap map) {
		Recruiter recruiter = recruiterDao.findById(id);
		if (recruiter.getOtp() == otp) {
			recruiter.setPassword(password);
			recruiterDao.save(recruiter);
			map.put("pass", "Password Reset Success");
			return "RecruiterLogin";
		} else {
			map.put("fail", "Invalid OTP");
			map.put("id", id);
			return "RecruiterPassword";
		}
	}

	public String addJob(Recruiter recruiter,Job job, HttpSession session, ModelMap map) {
		
		List<Job> list = recruiter.getJobs();
		if (list == null)
			list = new ArrayList<Job>();
		list.add(job);

		recruiter.setJobs(list);
		recruiterDao.save(recruiter);
		session.setAttribute("recruiter", recruiter);
		map.put("pass", "Job Posting Success");
		return "RecruiterHome";
	} 

}
