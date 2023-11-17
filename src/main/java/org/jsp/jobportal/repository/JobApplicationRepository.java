package org.jsp.jobportal.repository;

import org.jsp.jobportal.dto.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {

}
