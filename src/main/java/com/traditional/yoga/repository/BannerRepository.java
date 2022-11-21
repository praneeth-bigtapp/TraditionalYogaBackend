package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.BannerModel;
@Repository
public interface BannerRepository extends JpaRepository<BannerModel, Integer> {
	
	@Query(value = "SELECT * FROM `banner` WHERE `banner_id`=:bannerId;",nativeQuery = true)
	BannerModel getbannerById(@Param("bannerId") int bannerId);

}
