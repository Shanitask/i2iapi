package com.Beautosite.Service;

import com.Beautosite.dto.ResponseVe;
import com.Beautosite.dto.SubmitYourIdeaDto;

public interface SubmitYourIdeaService {
	
	ResponseVe createIdea(SubmitYourIdeaDto dto);

}
