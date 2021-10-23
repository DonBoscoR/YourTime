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

import com.your.time.bean.User;
import com.your.time.repository.ServiceProviderRepository;
import com.your.time.repository.UsersRepository;

@Component
public class UserService /*implements UserDetailsService*/ {

    @Autowired
    private UsersRepository usersRepository;
    
    @Autowired
    private ServiceProviderRepository serviceProviderRepository;
    
    //@Autowired PasswordEncoder passwordEncoder;
    
    @Autowired
    EmailService emailService;
    
    private static final Logger logger = Logger.getLogger(UserService.class.getName());
    
    //private org.springframework.security.core.userdetails.User userdetails;

    /*@Override
	public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        User user = getUserDetail(username);
        System.out.println(username);
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        System.out.println(user.getRole());
            
        userdetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(),user.getPassword(),getAuthorities(user.getRole()));
            return userdetails;
    }

    public List<GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority(role));
        System.out.println(authList);
        return authList;
    }*/

    public User getUserDetail(String username) {
    	User user = null;//usersRepository.findByUsername(username);
        //System.out.println(user.toString());
        return user;
    }

    public User save(User user) {
    	if(user != null){
    		
    		usersRepository.save(user);
    		/*if(user.isServiceProvider()){
	    		ServiceProvider serviceProvider = new ServiceProvider();
	    		serviceProvider.setServiceProviderTye(user.getServiceProviderTye());
	    		serviceProvider.setAddressline1(user.getAddressline1());
	    		serviceProvider.setAddressline2(user.getAddressline2());
	    		serviceProvider.setCountry(user.getCountry());
	    		serviceProvider.setDisplayName(user.getUsername());
	    		serviceProvider.setEmail(user.getEmail());
	    		serviceProvider.setOfficialName(user.getFirstname() +" "+user.getLastname());
	    		serviceProvider.setPhonenumber(user.getPhonenumber());
	    		serviceProvider.setState(user.getState());
	    		serviceProvider.setZip(user.getZip());
	    		serviceProvider.setIspId(user.getCountry().substring(0, 2)+""+user.getState().substring(0, 2)+""+user.getFirstname().substring(0, 2)+""+user.getLastname().substring(0, 2)+"001");
	    		serviceProviderDAO.save(serviceProvider);
	    		user.setServiceProviderDetail(serviceProvider);
    		}*/
    	}
		return user;
	}

    public Optional<User> findOne(User user) {
		return usersRepository.findOne(Example.of(user));
	}
    
	public List<User> findAll(User user) {
		return (List<User>) usersRepository.findAll(Example.of(user));
	}
	
	public List<User> findAll() {
		return (List<User>) usersRepository.findAll();
	}
	
	public void generateOneTimePassword(User customer)
	        throws UnsupportedEncodingException, MessagingException {
		
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String OTP = new String(array, Charset.forName("UTF-8"));

		
	    //String encodedOTP = passwordEncoder.encode(OTP);
	     
	    customer.setOtpString(OTP);
	    customer.setOtpValidTill(new Date());
	     
	    usersRepository.save(customer);
	     
	    emailService.sendOTPEmail(customer, OTP);
	}
	
	public User registerUser(User user) {
		
		return user;
	}
	
	public void clearOTP(User customer) {
	    customer.setOtpString(null);
	    customer.setOtpValidTill(null);
	    usersRepository.save(customer);   
	}
}