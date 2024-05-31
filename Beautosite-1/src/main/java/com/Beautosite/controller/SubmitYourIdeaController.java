package com.Beautosite.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Beautosite.Repo.SubmitYourIdeaRepository;
import com.Beautosite.Service.SubmitYourIdeaService;
import com.Beautosite.ServiceImpl.MinioAdaptor;
import com.Beautosite.dto.HireDto;
import com.Beautosite.dto.ResponseVe;
import com.Beautosite.dto.SubmitYourIdeaDto;
import com.Beautosite.model.SubmitYourIdea;

@RestController
@CrossOrigin

public class SubmitYourIdeaController {
	 @Autowired
	    MinioAdaptor minioAdapter;
	@Autowired
	public SubmitYourIdeaService submitYourIdeaService;
	
	@Autowired
	public SubmitYourIdeaRepository submitYourIdeaRepository;
	
	@PostMapping(value = "/submitYourIdea", consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE} )
	public ResponseEntity<?> createIdea(SubmitYourIdeaDto dto) {
		
		submitYourIdeaService.createIdea(dto);
		String fileName = dto.getAttachmentUpload().getOriginalFilename();
	    try {
	    	 minioAdapter.uploadFile(dto.getAttachmentUpload().getOriginalFilename(), dto.getAttachmentUpload().getBytes());
	    	dto.getAttachmentUpload().transferTo( new File("D:\\fileupload" + fileName));
	    } catch (Exception e) {
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    } 
	    return ResponseEntity.ok("Idea submitted.");
	  }
	
	@GetMapping(path = "/download/suggestions")
    public ResponseEntity<ByteArrayResource> uploadFile(@RequestParam(value = "file")  String file) throws IOException {
		 byte[] data = minioAdapter.getFile(file);
        ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + file + "\"")
                .body(resource);
	

    }

}
