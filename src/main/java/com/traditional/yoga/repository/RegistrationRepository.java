package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.RegistrationModel;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationModel, Integer> {

	@Query(value = "SELECT * FROM `registration` WHERE `registration_id`= :registrationId ", nativeQuery = true)
	RegistrationModel getRegistrationById(@Param("registrationId") int registrationId);
}
