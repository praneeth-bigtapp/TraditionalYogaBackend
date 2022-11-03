package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.LoginUser;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Integer> {
	
	@Query(value="SELECT * FROM `user` WHERE `name`=:userName",nativeQuery=true)
	LoginUser getUserById(@Param("userName") String userName);
	
}
	