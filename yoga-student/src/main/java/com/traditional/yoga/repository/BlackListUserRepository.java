package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.BlackListModel;
@Repository
public interface BlackListUserRepository extends JpaRepository<BlackListModel, Integer> {

	@Query(value = "SELECT * FROM `blacklist_users` WHERE `backlistuser_id`= :blacklistuserId ",nativeQuery = true)
	BlackListModel getBlackListById(@Param("blacklistuserId") int blacklistuserId);
	
	@Query(value = "SELECT * FROM `blacklist_users` WHERE `blacklistuser_email`= :blacklistuserEmail",nativeQuery = true)
	BlackListModel getBlackListByEmail(@Param("blacklistuserEmail") String blacklistuserEmail);
	
	@Query(value = "SELECT COUNT(*) FROM `blacklist_users`", nativeQuery = true)
	int countBlacklistUsers();
}
