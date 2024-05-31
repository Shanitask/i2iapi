package com.Beautosite.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Beautosite.Service.HireService;
import com.Beautosite.ServiceImpl.MinioAdaptor;
import com.Beautosite.dto.HireDto;
import com.Beautosite.dto.HiringResponse;
import com.Beautosite.dto.ResponseVe;
import com.Beautosite.util.CommonCheck;

import io.minio.messages.Bucket;

@RestController
@CrossOrigin
public class HiringController {
	@Autowired
	private HireService hiringservice;
	 @Autowired
	    MinioAdaptor minioAdapter;
	 
	    @GetMapping(path = "/buckets")
	    public List<Bucket> listBuckets() {
	        return minioAdapter.getAllBuckets();
	    }
	
	@PostMapping(value = "/hiring", consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE} )
	public HiringResponse savedetails(HireDto hireDto) throws IOException {
		HiringResponse response=new HiringResponse();
		CommonCheck check = new CommonCheck();
		hiringservice.savedetails(hireDto);
		String fileName = hireDto.getFile().getOriginalFilename();
	   
		 if(hireDto.getFile().getOriginalFilename().contains(".pdf")) {
	    	  minioAdapter.uploadFile(hireDto.getFile().getOriginalFilename(), hireDto.getFile().getBytes());

	    		hiringservice.savedetails(hireDto);
	    	//hireDto.getFile().transferTo( new File("/home/hp/fileuploaded/" + fileName));

	    		hiringservice.savedetails(hireDto);
	    	  response.setCode("200");
	  		response.setMessage("sucess");
	  		response.setReferenceKey(hireDto.getReferanceKey());
	  		response.setEmail(hireDto.getEmailId());
	    	}
		
	    	
	    	else {
	    		  response.setCode("500");
	    		  response.setMessage(HiringResponse.getPdf());
	    		  return response;
	    	}
	    
	    	 
		return response;
	  }
	
	
	
	@GetMapping(path = "/download")
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