package org.jsp.jobportal.repository;

import java.util.List;

import org.jsp.jobportal.dto.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer>
{

	List<Job> findByApprovedTrueAndNumberOfPositionsGreaterThan(int n);

}
