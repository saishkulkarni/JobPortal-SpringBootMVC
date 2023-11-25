package org.jsp.jobportal.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String email;
	long mobile;
	String password;
	String gender;
	LocalDate dob;
	String highestdegree;
	double tenthPercentage;
	double twelthPercentage;
	double degreePercenatge;
	double masterPercentage;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	byte[] resume;
	int otp;
	boolean verified;
	boolean prime;
	boolean experience;
	int workExperience;
	LocalDate noticePeriod;
	String roleDescription;
	boolean profileComplete;

	public boolean isProfileComplete() {
		return profileComplete;
	}

	public void setProfileComplete(boolean profileComplete) {
		this.profileComplete = profileComplete;
	}

	public double getTenthPercentage() {
		return tenthPercentage;
	}

	public void setTenthPercentage(double tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}

	public double getTwelthPercentage() {
		return twelthPercentage;
	}

	public void setTwelthPercentage(double twelthPercentage) {
		this.twelthPercentage = twelthPercentage;
	}

	public double getDegreePercenatge() {
		return degreePercenatge;
	}

	public void setDegreePercenatge(double degreePercenatge) {
		this.degreePercenatge = degreePercenatge;
	}

	public double getMasterPercentage() {
		return masterPercentage;
	}

	public void setMasterPercentage(double masterPercentage) {
		this.masterPercentage = masterPercentage;
	}

	public boolean isExperience() {
		return experience;
	}

	public void setExperience(boolean experience) {
		this.experience = experience;
	}

	public int getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}

	public LocalDate getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(LocalDate noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Notification> notifications;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<JobApplication> applications;

	public List<JobApplication> getApplications() {
		return applications;
	}

	public void setApplications(List<JobApplication> applications) {
		this.applications = applications;
	}

	public int getId() {
		return id;
	}

	public boolean isPrime() {
		return prime;
	}

	public void setPrime(boolean prime) {
		this.prime = prime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getHighestdegree() {
		return highestdegree;
	}

	public void setHighestdegree(String highestdegree) {
		this.highestdegree = highestdegree;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

}
