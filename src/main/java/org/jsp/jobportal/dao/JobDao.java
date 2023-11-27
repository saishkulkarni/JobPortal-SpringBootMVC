package org.jsp.jobportal.dao;

import java.util.List;

import org.jsp.jobportal.dto.Job;
import org.jsp.jobportal.dto.JobApplication;
import org.jsp.jobportal.repository.JobApplicationRepository;
import org.jsp.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobDao {
	@Autowired
	JobRepository jobRepository;

	@Autowired
	JobApplicationRepository applicationRepository;

	public List<Job> fetchAll() {
		return jobRepository.findAll();
	}

	public Job findById(int id) {
		return jobRepository.findById(id).orElse(null);
	}

	public void save(Job job) {
		jobRepository.save(job);
	}

	public List<Job> fetchAllApproved() {
		return jobRepository.findByApprovedTrueAndNumberOfPositionsGreaterThan(0);
	}

	public JobApplication findApplicationById(int id) {
		return applicationRepository.findById(id).orElse(null);
	}

	public void saveApplication(JobApplication application) {
		applicationRepository.save(application);
	}
}
