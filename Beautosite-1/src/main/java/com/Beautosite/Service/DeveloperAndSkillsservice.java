package com.Beautosite.Service;

import java.util.List;

import com.Beautosite.dto.DeveloperAndSkillsDto;
import com.Beautosite.dto.ResponseVe;
import com.Beautosite.model.DeveloperAndSkills;

public interface DeveloperAndSkillsservice {
public ResponseVe saveDeveloperandSkills(DeveloperAndSkillsDto developerandskillsDto);
public List<DeveloperAndSkills> findAll(String inputString);
}
