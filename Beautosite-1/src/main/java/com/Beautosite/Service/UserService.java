package com.Beautosite.Service;

import com.Beautosite.dto.UserDto;
import com.Beautosite.model.User;

public interface UserService {
	public void savedetails(UserDto request);
	public User getDetailsByid(int id);
	

}
