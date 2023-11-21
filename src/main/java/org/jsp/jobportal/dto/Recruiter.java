package org.jsp.jobportal.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Recruiter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String fullname;
	String email;
	long mobile;
	String password;
	String gender;
	String companyname;
	String companylocation;
	int otp;
	boolean verfied;
	LocalDateTime otpCreatedTime;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Job> jobs;

	public List<Job> getJobs() {
		return jobs;
	}

	public LocalDateTime getOtpCreatedTime() {
		return otpCreatedTime;
	}

	public void setOtpCreatedTime(LocalDateTime otpCreatedTime) {
		this.otpCreatedTime = otpCreatedTime;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public boolean isVerfied() {
		return verfied;
	}

	public void setVerfied(boolean verfied) {
		this.verfied = verfied;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanylocation() {
		return companylocation;
	}

	public void setCompanylocation(String companylocation) {
		this.companylocation = companylocation;
	}

}
