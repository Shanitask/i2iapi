package com.Beautosite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Beautosite.Repo.BeautoSiterepo;
import com.Beautosite.Service.BeautoSiteService;
import com.Beautosite.dto.BeautoSiteDto;
import com.Beautosite.dto.ResponseVe;
@RestController
@CrossOrigin
public class BeautoController {
	@Autowired
	private BeautoSiteService service;
	@Autowired
	private BeautoSiterepo repos;
	@PostMapping("/enquiry")
	public ResponseVe CreateBeautoSite(@RequestBody BeautoSiteDto dto) {
		ResponseVe response = new ResponseVe();
		
		 service.createBeautoSite(dto);
		
		 response.setResponseCode("200");
			response.setResponsemessage("Success");
		return response;
	}

}


