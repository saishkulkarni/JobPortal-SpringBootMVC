package org.jsp.jobportal.service;

import org.jsp.jobportal.dao.RecruiterDao;
import org.jsp.jobportal.dto.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class RecruiterService {

	@Autowired
	RecruiterDao recruiterDao;

	public String signup(Recruiter recruiter, ModelMap map) {
		Recruiter recruiter1 = recruiterDao.findByEmail(recruiter.getEmail());
		Recruiter recruiter2 = recruiterDao.findByMobile(recruiter.getMobile());
		if (recruiter1 == null && recruiter2 == null) {
			// Email Logic
			recruiterDao.save(recruiter);
			map.put("pass", "Otp Sent");
			return "RecruiterOtp";
		} else {
			map.put("fail", "Email or Mobile is Repeated");
			return "RecruiterSignup";
		}
	}

}
