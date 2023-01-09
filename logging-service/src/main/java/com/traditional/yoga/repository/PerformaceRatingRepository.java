package com.traditional.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.PerformaceRatingModel;

@Repository
public interface PerformaceRatingRepository extends JpaRepository<PerformaceRatingModel, Integer> {
	
	@Query(value = "SELECT * FROM `performace_rating` WHERE `id`= :performaceId ", nativeQuery = true)
	PerformaceRatingModel getRatingById(@Param("performaceId") int performaceId);
	
	@Query(value = "SELECT * FROM `performace_rating` WHERE `performace_name`= :performaceName ", nativeQuery = true)
	PerformaceRatingModel getRatingByName(@Param("performaceName") String performaceName);
	
	@Query(value = "SELECT * FROM `performace_rating` WHERE `course_id`= :courseId ", nativeQuery = true)
	List<PerformaceRatingModel> getRatingByCourseId(@Param("courseId") int courseId);
}
