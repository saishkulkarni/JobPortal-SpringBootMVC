package org.jsp.jobportal.repository;

import org.jsp.jobportal.dto.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer>
{

}
