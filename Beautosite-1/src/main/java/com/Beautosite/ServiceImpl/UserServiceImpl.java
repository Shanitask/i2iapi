package com.Beautosite.ServiceImpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.Beautosite.Repo.UserRepository;
import com.Beautosite.Service.UserService;
import com.Beautosite.dto.ResponseVe;
import com.Beautosite.dto.UserDto;
import com.Beautosite.model.User;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepo;
	@Autowired
	private EmailService emailservice;
	@Autowired
	private Configuration config;
	@Value("${spring.mail.username}")
	private String sender;
	
	@Override
	public void savedetails(UserDto request) {
	
		
		 User us =new User();
		 us.setOrganizationName(request.getOrganizationName());
		 us.setBuildedTeam(request.getBuildedTeam());
		 us.setMailId(request.getMailId());
		 us.setDiscription(request.getDiscription());
		 
		 User save=userrepo.save(us);
	
		 if(save!=null) {
			 
			 ResponseVe response = new ResponseVe();
			 String host = "smtp.gmail.com";

			 final String password = "qlnrzcyvtupnxhmx";
			 Properties props = new Properties();
			 props.put("mail.smtp.auth", "true");
			 props.put("mail.smtp.starttls.enable", "true");
			 props.put("mail.smtp.host", host);
			 props.put("mail.smtp.port", "587");
			 Session session = Session.getInstance(props,
 	         new javax.mail.Authenticator() {
 	            protected PasswordAuthentication getPasswordAuthentication() {
 	               return new PasswordAuthentication(sender, password);
 	            }
			 });
			 
			 MimeMessage mailMessage = new MimeMessage(session);

			 try {
				 MimeMessageHelper helper = new MimeMessageHelper(mailMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
						 StandardCharsets.UTF_8.name());
				 Map<String, Object> model = new HashMap<>();
				 model.put("request1", request);
		
				 Template t = config.getTemplate("email-template2.html");
				 String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
				 helper.setTo(request.getMailId());		
				 helper.setText(html, true);
				 helper.setSubject("You are uploaded Succesfully!!");
				 emailservice.sendEmail(mailMessage);

				 helper.setTo(sender);
				 helper.setSubject(" Requirment of Organization!!");
				 helper.setText("The Organization name is " + save.getOrganizationName()+" \r\norganization Requirments Description is  "+save.getDiscription()+" \r\nOrganization Requirments is "+save.getBuildedTeam());
				 emailservice.sendEmail(mailMessage);


			 	} catch (MessagingException | IOException | TemplateException e) {
			 		response.setResponsemessage("Mail Sending failure : "+e.getMessage());
			 		response.setResponseCode("404");
			 	}			
		 }		

	}


	public User getDetailsByid(int id) {
		return userrepo.getDetailsByid(id);		
}
	}
