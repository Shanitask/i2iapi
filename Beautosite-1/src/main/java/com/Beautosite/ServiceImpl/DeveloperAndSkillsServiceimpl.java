package com.Beautosite.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Beautosite.Repo.DeveloperAndskillsRepo;
import com.Beautosite.Repo.RequirementRepo;
import com.Beautosite.Service.DeveloperAndSkillsservice;
import com.Beautosite.dto.DeveloperAndSkillsDto;
import com.Beautosite.dto.ResponseVe;
import com.Beautosite.model.DeveloperAndSkills;
import com.Beautosite.model.Requirement;

import info.debatty.java.stringsimilarity.Cosine;
@Service
public class DeveloperAndSkillsServiceimpl implements DeveloperAndSkillsservice {
@Autowired
private DeveloperAndskillsRepo developerRepo;

@Autowired
private RequirementRepo requirementRepo;

	@Override
	public ResponseVe saveDeveloperandSkills(DeveloperAndSkillsDto developerandskillsDto) {
		ResponseVe response = new ResponseVe();
		DeveloperAndSkills model=new DeveloperAndSkills();
		model.setDeveloper(developerandskillsDto.getDeveloper());
		model.setSkills(developerandskillsDto.getSkills());
		model.setAvailibility(developerandskillsDto.getAvailibility());
		model.setLocation(developerandskillsDto.getLocation());
		model=developerRepo.save(model);
		response.setResponseCode("200");
		response.setResponsemessage("success");
		
		return response;
	}

	public List<DeveloperAndSkills> findAll(String requirement) {
		Cosine cosine = new Cosine(2);
		Requirement requirement2 = new Requirement();
		requirement2.setRequirement(requirement);
		List<DeveloperAndSkills> deviceOrganizationDtoList = new ArrayList<DeveloperAndSkills>();
		
		List<DeveloperAndSkills>   details=developerRepo.findAll();
		System.out.println(requirement);
	 for(DeveloperAndSkills developerandskills : details) {
		 if(cosine.similarity(requirement, developerandskills.getSkills())>0.5) {
			 deviceOrganizationDtoList.add(developerandskills); 
			 
		 }
			requirementRepo.save(requirement2);

		 System.out.println(deviceOrganizationDtoList);
		 
	 }
		return deviceOrganizationDtoList;
	}
	

}
