package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.OnlineExamsModel;
@Repository
public interface OnlineExamRepository extends JpaRepository<OnlineExamsModel, Integer> {

	@Query(value = "SELECT * FROM `online_exams` WHERE `exams_id`= :examsId", nativeQuery = true)
	OnlineExamsModel getexamdetailsById(@Param("examsId") int examsId);
	
}
