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

import com.Beautosite.Repo.SubmitYourIdeaRepository;
import com.Beautosite.Service.SubmitYourIdeaService;
import com.Beautosite.dto.ResponseVe;
import com.Beautosite.dto.SubmitYourIdeaDto;
import com.Beautosite.model.SubmitYourIdea;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class SubmitYourIdeaServiceImpl implements SubmitYourIdeaService{
	
	@Autowired
	SubmitYourIdeaRepository submitYourIdeaRepository;
	@Autowired
	private EmailService emailservice;
	@Autowired
	private Configuration config;
	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public ResponseVe createIdea(SubmitYourIdeaDto dto) {
		
		SubmitYourIdea model = new SubmitYourIdea();
			ResponseVe response= new ResponseVe();
			model.setFirstName(dto.getFirstName());
			model.setCountry(dto.getCountry());
			model.setEmailAddress(dto.getEmailAddress());
			model.setContactNumber(dto.getContactNumber());
			model.setAlternateContactNumber(dto.getAlternateContactNumber());
			model.setDomain(dto.getDomain());
			model.setIdeaStage(dto.getIdeaStage());
			model.setDescribeYourIdea(dto.getDescribeYourIdea());
			model.setAttachmentName(dto.getAttachmentUpload().getOriginalFilename());
			model.setOrganisationName(dto.getOrganisationName());
			SubmitYourIdea save=submitYourIdeaRepository.save(model);
			if(save!=null) {
//				SimpleMailMessage mailMessage = new SimpleMailMessage();
//				mailMessage.setTo(sender);
//				mailMessage.setSubject(" Hello welcome Beauto system");
//				mailMessage.setText("Hello  " + model.getFirstName()
//				+" /r/n Email Address   "+model.getEmailAddress()
//				+" /r/n Contact Number  "+model.getContactNumber());
//				emailservice.sendEmail(mailMessage);
//				
//				mailMessage.setTo(model.getEmailAddress());
//				mailMessage.setSubject(" You are uploaded Succesfully!!");
//				mailMessage.setText("You are uploaded Succesfully!!");
//				emailservice.sendEmail(mailMessage);
//
//				response.setResponseCode("200");
//				response.setResponsemessage("dropped your idea successfully");
//			}
//			return response;
//		}
				
				//ResponseVe response = new ResponseVe();
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
					
					helper.addAttachment(dto.getAttachmentUpload().getOriginalFilename(),dto.getAttachmentUpload());

					Map<String, Object> model1 = new HashMap<>();
					model1.put("hireDto1", dto);
					Template t = config.getTemplate("email-template-idea.html");
					String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model1);

					helper.setTo(sender);
					helper.setText(html, true);
					helper.setSubject("Client idea");
					emailservice.sendEmail(mailMessage);

					helper.setTo(dto.getEmailAddress());
					helper.setSubject("Your idea submitted Succesfully!!");
					emailservice.sendEmail(mailMessage);
				} catch (MessagingException | IOException | TemplateException e) {
					response.setResponsemessage("Mail Sending failure : "+e.getMessage());
					response.setResponseCode("404");
				}			
			}
				return null;
		}
		}
		
