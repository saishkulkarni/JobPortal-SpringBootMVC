package org.jsp.jobportal.dao;

import org.jsp.jobportal.dto.Recruiter;
import org.jsp.jobportal.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecruiterDao {
	
	@Autowired
	RecruiterRepository recruiterRepository;

	public Recruiter findByEmail(String email) {
		return recruiterRepository.findByEmail(email);
	}

	public Recruiter findByMobile(long mobile) {
		return recruiterRepository.findByMobile(mobile);
	}

	public void save(Recruiter recruiter) {
		recruiterRepository.save(recruiter);
	}

	public Recruiter findById(int id) {
		return recruiterRepository.findById(id).orElse(null);
	}

}
