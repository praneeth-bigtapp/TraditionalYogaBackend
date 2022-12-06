package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Integer> {
	
	@Query(value = "SELECT * FROM `task` WHERE `task_Id`= :taskId", nativeQuery = true)
	TaskModel getTaskById(@Param("taskId") int taskId);

}
