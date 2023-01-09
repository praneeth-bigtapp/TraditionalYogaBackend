package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.NotificationModel;
@Repository
public interface NoticationRepository extends JpaRepository<NotificationModel, Integer> {

	@Query(value = "SELECT * FROM `notification` WHERE `notification_id`= :notificationId", nativeQuery = true)
	NotificationModel getnotificationById(@Param("notificationId") int notificationId);
	
}
