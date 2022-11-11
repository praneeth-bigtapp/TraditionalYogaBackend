package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
	
	@Query(value="SELECT * FROM `user` WHERE `id`=:id",nativeQuery=true)
	UserModel getUserById(@Param("id") int id);
	
	@Query(value="SELECT * FROM `user` WHERE `name`=:userName",nativeQuery=true)
	UserModel getUserByName(@Param("userName") String userName);
	
}
	