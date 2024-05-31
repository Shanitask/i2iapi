package com.Beautosite.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Beautosite.model.Requirement;

@Repository
public interface RequirementRepo extends JpaRepository<Requirement, Integer> {

	//List<String> save(String requirement);

}
