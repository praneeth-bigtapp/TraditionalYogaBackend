package com.traditional.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.RegistrationModel;

public interface SuspecousUsersRepository extends JpaRepository<RegistrationModel, Integer> {
	
	
	@Query(value = "SELECT * FROM `registration` WHERE first_name = :firstName OR last_name = :surName OR pin_code = :pinCode OR house_number = :address", nativeQuery = true)
	List<RegistrationModel> getRegistrationByFilter(@Param("firstName") String firstName,
	        @Param("surName") String surName, @Param("pinCode") String pinCode, @Param("address") String address);

}
