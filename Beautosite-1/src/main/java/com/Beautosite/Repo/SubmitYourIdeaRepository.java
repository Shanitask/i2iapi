package com.Beautosite.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Beautosite.model.SubmitYourIdea;

@Repository
public interface SubmitYourIdeaRepository extends JpaRepository<SubmitYourIdea, Integer> {
	
	SubmitYourIdea findByEmailAddress(String emailAddress);

}
