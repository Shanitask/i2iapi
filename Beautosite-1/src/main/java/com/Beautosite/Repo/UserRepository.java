package com.Beautosite.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Beautosite.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User getDetailsByid(int id);
	

}
