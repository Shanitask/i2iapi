package com.Beautosite.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Beautosite.Service.UserService;
import com.Beautosite.dto.ResponseVe;
import com.Beautosite.dto.UserDto;
import com.Beautosite.model.User;


@RestController
@CrossOrigin
public class SiteController {
	@Autowired 
	private UserService us;
	
	@GetMapping("/")
	public void check() {
		System.out.println("hello");
	}

	 @PostMapping("/saveDetails")
	   public ResponseVe createOrUpdateInvoice(@RequestBody UserDto requet){
		 ResponseVe responsedto =new ResponseVe(); 
		  us.savedetails(requet);
		  responsedto.setResponseCode("200");
		  responsedto.setResponsemessage("success");
		  return responsedto;  
	   }
	 @GetMapping("/getdetials/{id}")
	 public User getDetailsByid(@PathVariable("id") int id) {
		 return  us.getDetailsByid(id);
		 
	 }
}
