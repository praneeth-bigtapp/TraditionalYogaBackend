package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.AddCoursesMaterialModel;

public interface AddMaterialRepository extends JpaRepository<AddCoursesMaterialModel, Integer> {

	
	@Query(value = "SELECT * FROM `add_course_materials` WHERE `course_material_id`= :courseMaterialId", nativeQuery = true)
	AddCoursesMaterialModel getmaterialById(@Param("courseMaterialId") int courseMaterialId);
}
