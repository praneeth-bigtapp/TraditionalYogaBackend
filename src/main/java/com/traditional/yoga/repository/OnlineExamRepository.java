package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.ClassMediaModel;
import com.traditional.yoga.model.onlineexamsModel;
@Repository
public interface OnlineExamRepository extends JpaRepository<onlineexamsModel, Integer> {

	@Query(value = "SELECT * FROM `online_exams` WHERE `exams_id`= :examsId", nativeQuery = true)
	onlineexamsModel getexamdetailsById(@Param("examsId") int examsId);
	
}
