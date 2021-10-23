package com.your.time.controller;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.your.time.bean.ServiceProvider;
import com.your.time.bean.Status;
import com.your.time.service.ServiceProviderService;
import com.your.time.util.YourTimeRestURIConstants;


@RestController
public class ServiceProviderController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private ServiceProviderService serviceProviderService;
	
	@PostMapping(value = YourTimeRestURIConstants.ServiceProviderWS.WS_SERVICE_PROVIDER_SIGN_UP)
	public Status<ServiceProvider> register(@RequestBody ServiceProvider serviceProvider) {
		Status<ServiceProvider> status = new Status<ServiceProvider>();
		serviceProvider = serviceProviderService.register(serviceProvider);
		if(serviceProvider != null){
			status.setStatus(true);
			status.setMessage("Registration is successful");
			status.setResult(serviceProvider);
		}else{
			status.setStatus(false);
			status.setMessage("Registration is not successful");
			status.setResult(serviceProvider);
		}
		return status;
	}
	
	@GetMapping(value=YourTimeRestURIConstants.ServiceProviderWS.WS_SERVICE_PROVIDER_HOME)
	public Status<ServiceProvider> home() {
		Status<ServiceProvider> status = new Status<ServiceProvider>();
		List<ServiceProvider> serviceProviders = (List<ServiceProvider>) serviceProviderService.findAll();
		if(serviceProviders == null || serviceProviders.size() == 0){
			status.setStatus(false);
			status.setMessage("No service providers available");
		}else{
			status.setStatus(true);
			status.setResults(serviceProviders);
			status.setMessage("Authendication is successful");
		}
		return status;
	}
	
	@PostMapping(value = YourTimeRestURIConstants.ServiceProviderWS.WS_SERVICE_PROVIDER_AUTHENDICATE)
	public Status<ServiceProvider> authendicate(@RequestBody ServiceProvider serviceProvider) {
		Status<ServiceProvider> status = new Status<ServiceProvider>();

		Optional<ServiceProvider> resultedServiceProvider = serviceProviderService.findOne(serviceProvider);
		if(resultedServiceProvider.isPresent()){
			status.setStatus(true);
			status.setResult(resultedServiceProvider.get());
			status.setMessage("Authendication is successful");
		}else{
			status.setStatus(false);
			status.setResult(serviceProvider);
			status.setMessage("Either Username or Password is incorrect");
		}
		return status;
	}
	
	/*@RequestMapping(value = YourTimeRestURIConstants.UsersWS.WS_SIGN_UP, method = RequestMethod.POST)
	public @ResponseBody Status<User> updateProfile(@RequestBody User user) {
		Status<User> status = new Status<User>();
		user.setServiceProvider(user.getServiceProviderTye() == null || user.getServiceProviderTye().isEmpty());
		user = userService.save(user);
		if(user != null){
			status.setStatus(true);
			status.setMessage("Your profile is updated");
			status.setResult(user);
		}else{
			status.setStatus(false);
			status.setMessage("Your profile could not be updated.");
			status.setResult(user);
		}
		return status;
	}*/
}