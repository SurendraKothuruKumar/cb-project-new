package com.training.licagentwebservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.licagentwebservice.model.LicAgent;
@Repository
public interface LicAgentRepository extends JpaRepository<LicAgent, Integer> {
	public List<LicAgent> findAllByManagerId(int managerId);

}
