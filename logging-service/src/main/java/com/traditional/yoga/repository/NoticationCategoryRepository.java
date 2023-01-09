package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.NotificationCategoryModel;

@Repository
public interface NoticationCategoryRepository extends JpaRepository<NotificationCategoryModel, Integer> {

	@Query(value = "SELECT * FROM `notification_category` WHERE `category_id`= :categoryId", nativeQuery = true)
	NotificationCategoryModel getnotificationById(@Param("categoryId") int categoryId);
	
}
