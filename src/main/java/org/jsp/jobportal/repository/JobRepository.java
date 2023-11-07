package org.jsp.jobportal.repository;

import org.jsp.jobportal.dto.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer>
{

}
