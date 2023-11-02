package org.jsp.jobportal.dao;

import org.jsp.jobportal.dto.User;
import org.jsp.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findByMobile(long mobile) {
		return userRepository.findByMobile(mobile);
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public User findById(int id) {
		return userRepository.findById(id).orElse(null);
	}

}
