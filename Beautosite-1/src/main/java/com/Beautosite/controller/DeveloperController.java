package com.Beautosite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import com.Beautosite.Service.DeveloperAndSkillsservice;
import com.Beautosite.dto.DeveloperAndSkillsDto;
import com.Beautosite.dto.ResponseVe;
import com.Beautosite.model.DeveloperAndSkills;
import com.Beautosite.model.Requirement;

@RestController
@CrossOrigin
public class DeveloperController {

	@Autowired
	private DeveloperAndSkillsservice developerservice;
	
	
	@PostMapping(value="/save")
	public ResponseVe saveDeails(@RequestBody DeveloperAndSkillsDto dto) {
		ResponseVe response = new ResponseVe();
		developerservice.saveDeveloperandSkills(dto);
		response.setResponseCode("200");
		response.setResponsemessage("success");
		
		return response;
		
	}
	@PostMapping("/search")
    public List<DeveloperAndSkills> searchPlants(@RequestPart("requirement") String requirement) {

		List<DeveloperAndSkills> details=developerservice.findAll(requirement);

        return details;
    }
}
