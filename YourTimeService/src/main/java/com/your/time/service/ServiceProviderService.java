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

import com.your.time.bean.ServiceProvider;
import com.your.time.repository.ServiceProviderRepository;

@Component
public class ServiceProviderService /*implements UserDetailsService*/ {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;
    
    @Autowired
    EmailService emailService;
    
    private static final Logger logger = Logger.getLogger(ServiceProviderService.class.getName());
    
    public ServiceProvider getServiceProviderDetail(String username) {
    	ServiceProvider serviceProvider = null;//serviceProviderRepository.findByUsername(username);
        return serviceProvider;
    }

    public ServiceProvider register(ServiceProvider serviceProvider) {
    	if(serviceProvider != null){
    		
    		serviceProviderRepository.save(serviceProvider);
    	}
		return serviceProvider;
	}

    public Optional<ServiceProvider> findOne(ServiceProvider serviceProvider) {
		return serviceProviderRepository.findOne(Example.of(serviceProvider));
	}
    
	public List<ServiceProvider> findAll(ServiceProvider serviceProvider) {
		return (List<ServiceProvider>) serviceProviderRepository.findAll(Example.of(serviceProvider));
	}
	
	public List<ServiceProvider> findAll() {
		return (List<ServiceProvider>) serviceProviderRepository.findAll();
	}
	
	public ServiceProvider save(ServiceProvider serviceProvider) {
		return serviceProviderRepository.save(serviceProvider);
	}
	
	public void generateOneTimePassword(ServiceProvider serviceProvider)
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
	
	public ServiceProvider registerUser(ServiceProvider serviceProvider) {
		
		return serviceProvider;
	}
	
	public void clearOTP(ServiceProvider serviceProvider) {
		serviceProvider.setOtpString(null);
		serviceProvider.setOtpValidTill(null);
	    serviceProviderRepository.save(serviceProvider);   
	}
}