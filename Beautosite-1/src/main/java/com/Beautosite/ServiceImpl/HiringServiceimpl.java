package com.Beautosite.ServiceImpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.Beautosite.Repo.HireRepo;
import com.Beautosite.Service.HireService;
import com.Beautosite.dto.HireDto;
import com.Beautosite.dto.HiringResponse;
import com.Beautosite.dto.ResponseVe;
import com.Beautosite.model.Hiring;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
@Service
public class HiringServiceimpl implements HireService {
	@Autowired
	private HireRepo hirerepo;
	@Autowired
	private EmailService emailservice;
	
	@Autowired
	private Configuration config;
	
	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public HireDto savedetails(HireDto hireDto) {
		Hiring hiring=new Hiring();
		String referanceKey = UUID.randomUUID().toString();
		hiring.setReferanceKey(referanceKey);
		hiring.setFirstName(hireDto.getFirstName());
		hiring.setLastName(hireDto.getLastName());
		hiring.setEmailId(hireDto.getEmailId());
		hiring.setContactNumber(hireDto.getContactNumber());
		hiring.setAlterNateContactNumber(hireDto.getAlterNateContactNumber());
		hiring.setAddress(hireDto.getAddress());
		hiring.setWorkLink(hireDto.getWorkLink());
		hiring.setCountry(hireDto.getCountry());
		hiring.setFileName(hireDto.getFile().getOriginalFilename());
		hiring=hirerepo.save(hiring);
		System.out.println(hiring);
	   	 	
		if(hiring!=null) {
		ResponseVe response = new ResponseVe();
	      String host = "smtp.gmail.com";

	     final String password = "qlnrzcyvtupnxhmx";
		 Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");
	      Session session = Session.getInstance(props,
	 	         new javax.mail.Authenticator()
	      {
	 	            protected PasswordAuthentication getPasswordAuthentication() {
	 	               return new PasswordAuthentication(sender, password);
	 	            }
	 		});		
		MimeMessage mailMessage = new MimeMessage(session);
		try {
			// set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(mailMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			// add attachment
			helper.addAttachment(hireDto.getFile().getOriginalFilename(),hireDto.getFile());
			Map<String, Object> model = new HashMap<>();
			model.put("hireDto1", hireDto);
			
			Template t = config.getTemplate("email-template-hiring.html");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			helper.setTo(sender);
			helper.setText(html, true);
			helper.setSubject("Meeting details are us follows....");
			emailservice.sendEmail(mailMessage);
			
			helper.setTo(hireDto.getEmailId());
			helper.setText("You are uploaded Succesfully!!");
			helper.setSubject("You are uploaded Succesfully!!");
			emailservice.sendEmail(mailMessage);

		} catch (MessagingException | IOException | TemplateException e) {
			response.setResponsemessage("Mail Sending failure : "+e.getMessage());
			response.setResponseCode("404");
		}			
	}
		return null;
}
  }

