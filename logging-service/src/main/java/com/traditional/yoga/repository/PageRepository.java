package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.PageModel;

@Repository
public interface PageRepository extends JpaRepository<PageModel, Integer>{
	
	@Query(value = "SELECT * FROM `pages` WHERE `pages_id`= :pageId", nativeQuery = true)
	PageModel getpageById(@Param("pageId") int pageId);
	
	@Query(value = "SELECT * FROM `pages` WHERE `pages_title`= :pageTitle", nativeQuery = true)
	PageModel getpageByname(@Param("pageTitle") String  pageTitle);
	
	
	@Query(value = "SELECT * FROM `pages` WHERE `description`= :description", nativeQuery = true)
	PageModel getpageBydescription(@Param("description") String  description);
	
	
	@Query(value = "SELECT * FROM `pages` WHERE `page_text`= :pageText", nativeQuery = true)
	PageModel getpageBytext(@Param("pageText") String  pageText);

}
