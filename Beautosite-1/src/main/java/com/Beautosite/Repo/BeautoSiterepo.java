package com.Beautosite.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Beautosite.model.BeautoSite;
@Repository
public interface BeautoSiterepo extends JpaRepository<BeautoSite, Integer>{
	public BeautoSite findByEmail(String email);
}
