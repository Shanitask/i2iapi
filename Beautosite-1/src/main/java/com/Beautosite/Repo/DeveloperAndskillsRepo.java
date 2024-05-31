package com.Beautosite.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Beautosite.dto.DeveloperAndSkillsDto;
import com.Beautosite.model.DeveloperAndSkills;
@Repository
public interface DeveloperAndskillsRepo extends JpaRepository<DeveloperAndSkills, Integer> {
	public List<DeveloperAndSkills>  findAll();

}
