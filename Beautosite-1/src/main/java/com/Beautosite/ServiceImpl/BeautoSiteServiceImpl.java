package com.Beautosite.ServiceImpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.Beautosite.Repo.BeautoSiterepo;
import com.Beautosite.Service.BeautoSiteService;
import com.Beautosite.dto.BeautoSiteDto;
import com.Beautosite.dto.ResponseVe;
import com.Beautosite.model.BeautoSite;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class BeautoSiteServiceImpl implements BeautoSiteService {
	@Autowired
	private BeautoSiterepo repos;
	@Autowired
	private EmailService emailService;
	@Autowired
	private Configuration config;
	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public ResponseVe createBeautoSite(BeautoSiteDto dto) {
		ResponseVe response = new ResponseVe();
			BeautoSite entity=new BeautoSite();
				entity.setFirstName(dto.getFirstName());
				entity.setLastName(dto.getLastName());
				entity.setEmail(dto.getEmail());
				entity.setContactNumber(dto.getContactNumber());
				entity.setBriefForTheMeeting(dto.getBriefForTheMeeting());
				entity.setBudget(dto.getBudget());
				entity.setSelectOffice(dto.getSelectOffice());
				entity.setDate(dto.getDate());
				entity.setTime(dto.getTime());
				repos.save(entity);
//				response.setResponseCode("200");
//				response.setResponsemessage("Success");
//				System.out.println(entity.toString());
				
				
				
				if (entity != null) {				

			      String host = "smtp.gmail.com";

				 //final String username = "dhanashreeilhe@gmail.com";//change accordingly
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
					// set mediaType
					MimeMessageHelper helper = new MimeMessageHelper(mailMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
							StandardCharsets.UTF_8.name());
					// add attachment
					//helper.addAttachment("logo.png", new ClassPathResource("https://www.beautosys.com/emailtemplateImg/logo.svg"));
					Map<String, Object> model = new HashMap<>();
					model.put("Dto1", dto);
					Template t = config.getTemplate("email-template.html");
					String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

					helper.setTo(sender);
					helper.setText(html, true);
					helper.setSubject("Meeting Details");
					emailService.sendEmail(mailMessage);

					helper.setTo(dto.getEmail());
					helper.setSubject("Meeting Details");
					emailService.sendEmail(mailMessage);

				} catch (MessagingException | IOException | TemplateException e) {
					response.setResponsemessage("Mail Sending failure : "+e.getMessage());
					response.setResponseCode("404");
				}			
			}
				return null;
		}

//			if (entity != null) {				
//				SimpleMailMessage mailMessage = new SimpleMailMessage();
//				mailMessage.setTo(sender);
//				mailMessage.setSubject(" Hello");
////				mailMessage.setText("Hello,  :- " + entity.getFirstName()+"\r\n Your meeting Details are as follows./r/n "+"\r\n Date " 
////				+entity.getDate()+ "/r/n  Email Address  "+ entity.getEmail()+ "\r\n Contact Number :-"
////				+entity.getContectNumber()+"\r\n Budget is :- "+entity.getBudGet()
////				+"\r\n Select Office :- "+entity.getSelectOffice()
////				+"\r\n Brief for meeting  "+entity.getBriegForTheMeeting());
//				
//				mailMessage.setText("Hello  \r\n"
//					 + entity.getFirstName()+"\r\n Your meeting Details are as follows"+"\r\n Date "+entity.getDate()+"\r\n Email Address   "+ entity.getEmail()+ "\r\n Contact Number "+entity.getContectNumber()+"\r\n Budget is "+entity.getBudGet()+"\r\nSelect Office  "+entity.getSelectOffice()+"\r\n Brief for meeting  "+entity.getBriegForTheMeeting()) ;
//		
//				emailService.sendEmail(mailMessage);
//				
//				mailMessage.setTo(entity.getEmail());
//				mailMessage.setSubject("Your opinion will be considered!!");
//				mailMessage.setText("Your opinion will be considered!!");
//				emailService.sendEmail(mailMessage);
//
//				response.setResponseCode("200");
//				response.setResponsemessage("Success");
//			}
//		return response;
//	}
//


}
