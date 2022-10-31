package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traditional.yoga.model.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {

}
