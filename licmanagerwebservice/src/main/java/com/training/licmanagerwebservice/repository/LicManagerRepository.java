package com.training.licmanagerwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.licmanagerwebservice.model.LicManager;
@Repository
public interface LicManagerRepository extends JpaRepository<LicManager, Integer> {

}
