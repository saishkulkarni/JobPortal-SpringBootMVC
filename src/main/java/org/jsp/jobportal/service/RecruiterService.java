package org.jsp.jobportal.service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jsp.jobportal.dao.JobDao;
import org.jsp.jobportal.dao.RecruiterDao;
import org.jsp.jobportal.dto.Job;
import org.jsp.jobportal.dto.JobApplication;
import org.jsp.jobportal.dto.Recruiter;
import org.jsp.jobportal.helper.EmailLogic;
import org.jsp.jobportal.helper.JobStatus;
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
	JobDao jobDao;

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

	public String addJob(Recruiter recruiter, Job job, HttpSession session, ModelMap map) {
		job.setRecruiter(recruiter);
		List<Job> list = recruiter.getJobs();
		if (list == null)
			list = new ArrayList<Job>();
		list.add(job);

		recruiter.setJobs(list);
		recruiterDao.save(recruiter);
		session.setAttribute("recruiter", recruiterDao.findById(recruiter.getId()));
		map.put("pass", "Job Posting Success");
		return "RecruiterHome";
	}

	public String getJobs(Recruiter recruiter, ModelMap map) {
		List<Job> jobs = recruiter.getJobs();
		if (jobs.isEmpty()) {
			map.put("fail", "No Job Posted Yet");
			return "RecruiterHome";
		} else {
			map.put("jobs", jobs);
			return "ViewRecruiterJobs";
		}
	}

	public String viewApplication(Recruiter recruiter, ModelMap map) {
		List<Job> jobs = recruiter.getJobs();
		if (jobs == null || jobs.isEmpty()) {
			map.put("fail", "No Job Posted Yet");
			return "RecruiterHome";
		} else {
			map.put("jobs", jobs);
			return "SeeAllApplications";
		}
	}

	public String viewApplication(int id, ModelMap map) {
		Job job = jobDao.findById(id);
		if (job == null) {
			map.put("fail", "Something went wrong");
			return "Home";
		} else {
			List<JobApplication> applications = job.getApplications();
			if (applications == null || applications.isEmpty()) {
				map.put("fail", "No Applications Yet");
				return "RecruiterHome";
			} else {
				map.put("applications", applications);
				return "ViewJobApplications";
			}
		}
	}

	public String scheduleInterview(int id, LocalDateTime interviewDate, ModelMap map, HttpSession session,
			Recruiter recruiter) {
		JobApplication application = jobDao.findApplicationById(id);
		if (application == null) {
			map.put("fail", "Something Went Wrong");
			return "Home";
		} else {
			application.setJobStatus(JobStatus.SCHEDULED);
			application.setInterviewDate(interviewDate);
			jobDao.saveApplication(application);
			session.setAttribute("recruiter", recruiterDao.findById(id));
			return viewApplication(application.getJob().getId(), map);
		}
	}

}
