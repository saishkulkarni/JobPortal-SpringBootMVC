package org.jsp.jobportal.service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.jsp.jobportal.dao.JobDao;
import org.jsp.jobportal.dao.UserDao;
import org.jsp.jobportal.dto.Job;
import org.jsp.jobportal.dto.User;
import org.jsp.jobportal.helper.EmailLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	JobDao jobDao;

	@Autowired
	EmailLogic emailLogic;

	public String signup(User user, MultipartFile doc, ModelMap map) throws IOException, MessagingException {
		byte[] resume = new byte[doc.getInputStream().available()];
		doc.getInputStream().read(resume);
		user.setResume(resume);
		User user1 = userDao.findByEmail(user.getEmail());
		User user2 = userDao.findByMobile(user.getMobile());
		if (user1 == null && user2 == null) {
			int otp = new Random().nextInt(100000, 999999);
			user.setOtp(otp);
			// emailLogic.sendOtp(user);
			userDao.save(user);
			map.put("pass", "Otp Sent");
			map.put("id", user.getId());
			return "UserOtp";
		} else {
			map.put("fail", "Email or Mobile is Repeated");
			return "UserSignup";
		}
	}

	public String verifyotp(int id, int otp, ModelMap map) {
		User user = userDao.findById(id);
		if (user == null) {
			map.put("fail", "Invalid ID");
			return "Home";
		} else {
			if (user.getOtp() == otp) {
				user.setVerified(true);
				userDao.save(user);
				map.put("pass", "Account verified Success");
				return "UserLogin";
			} else {
				map.put("fail", "Invalid OTP");
				map.put("id", id);
				return "UserOtp";
			}
		}
	}

	public String login(String email, String password, ModelMap map, HttpSession session) {
		User user = userDao.findByEmail(email);
		if (user == null) {
			map.put("fail", "Invalid Email");
			return "UserLogin";
		} else {
			if (user.getPassword().equals(password)) {
				if (user.isVerified()) {
					map.put("pass", "Login Succcess");
					map.put("user", user);
					session.setAttribute("user", user);
					return "UserHome";
				} else {
					map.put("fail", "Account Not Verified");
					return "UserLogin";
				}
			} else {
				map.put("fail", "Invalid Password");
				return "UserLogin";
			}
		}
	}

	public String forgotPassword(String email, ModelMap map) {
		User user = userDao.findByEmail(email);
		if (user == null) {
			map.put("fail", "Email Doesnot Exist");
			return "UserEmail";
		} else {
			int otp = new Random().nextInt(100000, 999999);
			user.setOtp(otp);
			// emailLogic.sendOtp(user);
			userDao.save(user);
			map.put("pass", "Otp Sent");
			map.put("id", user.getId());
			return "UserPassword";
		}
	}

	public String resetPassword(String password, int id, int otp, ModelMap map) {
		User user = userDao.findById(id);
		if (user.getOtp() == otp) {
			user.setPassword(password);
			userDao.save(user);
			map.put("pass", "Password Reset Success");
			return "UserLogin";
		} else {
			map.put("fail", "Invalid OTP");
			map.put("id", id);
			return "UserPassword";
		}
	}

	public String getJobs(ModelMap map) {
		List<Job> jobs = jobDao.fetchAllApproved();
		if (jobs.isEmpty()) {
			map.put("fail", "No Job Posted Yet");
			return "UserHome";
		} else {
			map.put("jobs", jobs);
			return "ViewUserJobs";
		}
	}

	public String applyJob(int id, User user, ModelMap map) {
		Job job = jobDao.findById(id);
		if (job == null) {
			map.put("fail", "Something went Wrong");
			return "Home";
		}
		else {
			if(job.getCtc()<=4 || user.isPrime())
			{
				//Logic for Applying
				map.put("pass", "Applied Success");
				return "UserHome";
			}
			else {
				map.put("fail", "You have to be Prime memeber for Applying to this");
				return "UserHome";
			}
		}
	}

	public String buyPrime(User user, ModelMap map) {
		return null;
	}

}
