package org.jsp.jobportal.repository;

import org.jsp.jobportal.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

	User findByMobile(long mobile);

}
