package com.Beautosite;



import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Beautosite.Repo.HireRepo;
import com.Beautosite.Service.HireService;
import com.Beautosite.dto.HireDto;
import com.Beautosite.dto.HiringResponse;

import com.Beautosite.model.Hiring;


@SpringBootTest
public class HiringDetailsTest {
	@Autowired
	private HireService hireservice;
	
	@MockBean
	private HireRepo hirerepo;
	private HireDto hiredto; 
    private HiringResponse hiring;
	private Hiring hir;
	
	
//	@Test
//	  public void saveHiringdetails(Object userDtoRequest) {
//
//		HireDto HireDto = new HireDto();
//	    hiring.setReferenceKey("key");
//	    hiring.setEmail("dhanu@123");
//
//	    HireDto hire = hireservice.savedetails(HireDto);
//	    assertEquals(HireDto,hiredto
//		System.out.println("save---"+withCash);
//	}
	@Test
	public void saveHiringdetails() 
	{
		when (hireservice.savedetails(hiredto)).thenReturn(hiredto);
		assertNotEquals(hiredto,hireservice.savedetails(hiredto));
		System.out.println(hiredto);
		
	}
	}

