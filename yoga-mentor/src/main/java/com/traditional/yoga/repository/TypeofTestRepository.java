package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.CourseMediaModel;
import com.traditional.yoga.model.TestTypeModel;

@Repository
public interface TypeofTestRepository extends JpaRepository<TestTypeModel, Integer> {

	
	@Query(value = "SELECT * FROM `type_of_test` WHERE `test_id`= :testId", nativeQuery = true)
	CourseMediaModel gettypeoftestById(@Param("testId") int testId);
}
