package com.your.time.service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.your.time.entity.Service;
import com.your.time.repository.ServiceRepository;

@Component
public class ServiceProviderService /*implements UserDetailsService*/ {

    @Autowired
    private ServiceRepository serviceProviderRepository;
    
    @Autowired
    EmailService emailService;
    
    private static final Logger logger = Logger.getLogger(ServiceProviderService.class.getName());
    
    public Service getServiceProviderDetail(String username) {
    	Service serviceProvider = null;//serviceProviderRepository.findByUsername(username);
        return serviceProvider;
    }

    public Service register(Service serviceProvider) {
    	if(serviceProvider != null){
    		
    		serviceProviderRepository.save(serviceProvider);
    	}
		return serviceProvider;
	}

    public Optional<Service> findOne(Service serviceProvider) {
		return serviceProviderRepository.findOne(Example.of(serviceProvider));
	}
    
	public List<Service> findAll(Service serviceProvider) {
		return (List<Service>) serviceProviderRepository.findAll(Example.of(serviceProvider));
	}
	
	public List<Service> findAll() {
		return (List<Service>) serviceProviderRepository.findAll();
	}
	
	public Service save(Service serviceProvider) {
		return serviceProviderRepository.save(serviceProvider);
	}
	
	public void generateOneTimePassword(Service serviceProvider)
	        throws UnsupportedEncodingException, MessagingException {
		
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String OTP = new String(array, Charset.forName("UTF-8"));

		
	    //String encodedOTP = passwordEncoder.encode(OTP);
	     
	    serviceProvider.setOtpString(OTP);
	    serviceProvider.setOtpValidTill(new Date());
	     
	    serviceProviderRepository.save(serviceProvider);
	     
	    emailService.sendOTPEmail(serviceProvider, OTP);
	}
	
	public Service registerUser(Service serviceProvider) {
		
		return serviceProvider;
	}
	
	public void clearOTP(Service serviceProvider) {
		serviceProvider.setOtpString(null);
		serviceProvider.setOtpValidTill(null);
	    serviceProviderRepository.save(serviceProvider);   
	}
}