package com.your.time.controller;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.your.time.bean.Status;
import com.your.time.bean.User;
import com.your.time.service.UserService;
import com.your.time.util.YourTimeRestURIConstants;


@RestController
public class UsersController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value=YourTimeRestURIConstants.UsersWS.WS_CONSUMER_HOME)
	public ResponseEntity consumerHome() {
		Status<User> status = new Status<User>();
		List<User> users = (List<User>) userService.findAll();
		if(users == null || users.size() == 0){
			status.setStatus(false);
			status.setMessage("No users available");
		}else{
			status.setStatus(true);
			status.setResults(users);
			status.setMessage("Authendication is successful");
		}
		return new ResponseEntity(status, HttpStatus.FOUND);
	}
	
	@PostMapping(value = YourTimeRestURIConstants.UsersWS.WS_CONSUMER_AUTHENDICATE)
	public Status<User>  authendicate(@RequestBody User user) {
		Status<User> status = new Status<User>();

		Optional<User> resultedUser = userService.findOne(user);
		if(resultedUser.isPresent()){
			status.setStatus(true);
			status.setResult(resultedUser.get());
			status.setMessage("Authendication is successful");
		}else{
			status.setStatus(false);
			status.setResult(user);
			status.setMessage("Either Username or Password is incorrect");
		}
		return status;
	}
	
	@PostMapping(value = YourTimeRestURIConstants.UsersWS.WS_CONSUMER_SIGN_UP)
	public Status<User> registerConsumer(@RequestBody User user) {
		Status<User> status = new Status<User>();
		//user.setServiceProvider(user.getServiceProviderTye() == null || user.getServiceProviderTye().isEmpty());
		user = userService.save(user);
		if(user != null){
			status.setStatus(true);
			status.setMessage("Registration is successful");
			status.setResult(user);
		}else{
			status.setStatus(false);
			status.setMessage("Registration is not successful");
			status.setResult(user);
		}
		return status;
	}
}