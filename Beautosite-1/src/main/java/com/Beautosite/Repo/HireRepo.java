package com.Beautosite.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Beautosite.dto.HireDto;
import com.Beautosite.model.Hiring;
@Repository
public interface HireRepo extends JpaRepository<Hiring, Integer> {



	
}
