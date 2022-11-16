package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.DonationModel;
import com.traditional.yoga.model.EPurchaseInformation;
@Repository
public interface EpurchaseInformation extends JpaRepository<EPurchaseInformation, Integer> {

	@Query(value = "SELECT * FROM `epurchaseinformation` WHERE `epurchase_id`=:epurchaseId;",nativeQuery = true)
	EPurchaseInformation getepurchaseInformationById(@Param("epurchaseId") int epurchaseId);
	
	
}
