package org.jsp.jobportal.repository;

import org.jsp.jobportal.dto.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepository extends JpaRepository<Recruiter, Integer>
{

	Recruiter findByEmail(String email);

	Recruiter findByMobile(long mobile);

}
