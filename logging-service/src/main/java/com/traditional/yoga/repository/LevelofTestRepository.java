package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.CourseMediaModel;
import com.traditional.yoga.model.LevelOfTestModel;

@Repository
public interface LevelofTestRepository  extends JpaRepository<LevelOfTestModel, Integer>{
	
	@Query(value = "SELECT * FROM `level_of_test` WHERE `level_Id`= :testId", nativeQuery = true)
	CourseMediaModel getleveloftestById(@Param("testId") int testId);

}
