package com.traditional.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.VolunteerModel;

@Repository
public interface VolunteerRepository extends JpaRepository<VolunteerModel, Integer> {

	@Query(value = "SELECT * FROM `volunteer` WHERE `student_id`= :studentId", nativeQuery = true)
	List<VolunteerModel> getVolunteerByStudentId(@Param("studentId") int studentId);

	@Query(value = "SELECT * FROM `volunteer` WHERE `student_id`= :studentId AND `category_name` = :categoryName", nativeQuery = true)
	VolunteerModel checkVolunteer(@Param("studentId") int studentId, @Param("categoryName") String categoryName);
}
