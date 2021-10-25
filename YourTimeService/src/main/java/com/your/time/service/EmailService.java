package com.your.time.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.your.time.entity.Service;
import com.your.time.entity.User;

@Component
public class EmailService {
	
    @Autowired JavaMailSender mailSender;
     
	public void sendOTPEmail(User customer, String OTP)
	        throws UnsupportedEncodingException, MessagingException {
	    MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom("contact@shopme.com", "Shopme Support");
	    helper.setTo(customer.getEmail());
	     
	    String subject = "Here's your One Time Password (OTP) - Expire in 5 minutes!";
	     
	    String content = "<p>Hello " + customer.getFirstname() + "</p>"
	            + "<p>For security reason, you're required to use the following "
	            + "One Time Password to login:</p>"
	            + "<p><b>" + OTP + "</b></p>"
	            + "<br>"
	            + "<p>Note: this OTP is set to expire in 5 minutes.</p>";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);      
	}
	
	public void sendOTPEmail(Service serviceProvider, String OTP)
	        throws UnsupportedEncodingException, MessagingException {
	    MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom("contact@shopme.com", "Shopme Support");
	    helper.setTo(serviceProvider.getContactEmail());
	     
	    String subject = "Here's your One Time Password (OTP) - Expire in 5 minutes!";
	     
	    String content = "<p>Hello " + serviceProvider.getOfficialName() + "</p>"
	            + "<p>For security reason, you're required to use the following "
	            + "One Time Password to login:</p>"
	            + "<p><b>" + OTP + "</b></p>"
	            + "<br>"
	            + "<p>Note: this OTP is set to expire in 5 minutes.</p>";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);      
	}
	
}
