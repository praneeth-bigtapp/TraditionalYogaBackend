package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.BannerModel;
import com.traditional.yoga.model.BannerViewModel;

@Repository
public interface BannerViewRepository extends JpaRepository<BannerViewModel, Integer> {

	@Query(value = "SELECT * FROM `banner_view` WHERE `banner_id`= :bannerId",nativeQuery = true)
	BannerViewModel getbannerbyId(@Param("bannerId") int bannerId);
}
