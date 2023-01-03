package com.traditional.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.DonationModel;

@Repository
public interface DonationRepository extends JpaRepository<DonationModel, Integer> {

	@Query(value = "SELECT * FROM `donation` WHERE `donation_id`= :donationId", nativeQuery = true)
	DonationModel getDonationById(@Param("donationId") int donationId);

	@Query(value = "SELECT * FROM `donation` WHERE `donar_id`= :donarId", nativeQuery = true)
	List<DonationModel> getDonationByStudentId(@Param("donarId") int donarId);
	
	@Query(value = "SELECT SUM(`amount_donated`) FROM `donation`", nativeQuery = true)
	int sumAmontDonation();

}
