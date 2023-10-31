package org.jsp.jobportal.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.jsp.jobportal.dao.RecruiterDao;
import org.jsp.jobportal.dto.Recruiter;
import org.jsp.jobportal.helper.EmailLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.mail.MessagingException;

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
			int otp=new Random().nextInt(100000, 999999);
			recruiter.setOtp(otp);
			emailLogic.sendOtp(recruiter);
			recruiterDao.save(recruiter);
			map.put("pass", "Otp Sent");
			return "RecruiterOtp";
		} else {
			map.put("fail", "Email or Mobile is Repeated");
			return "RecruiterSignup";
		}   
	}

}
