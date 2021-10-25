package com.your.time.controller;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.your.time.dto.AppointmentDto;
import com.your.time.dto.Dashboard;
import com.your.time.dto.Status;
import com.your.time.entity.Appointment;
import com.your.time.entity.Feedback;
import com.your.time.entity.User;
import com.your.time.repository.AppointmentRepository;
import com.your.time.service.UserService;
import com.your.time.util.YourTimeRestURIConstants;


@RestController
public class UsersController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AppointmentRepository as;
	
	@PostMapping(value = YourTimeRestURIConstants.UsersWS.WS_USER_SIGN_UP)
	public Status<User> register(@RequestBody User user) {
		Status<User> status = new Status<User>();
		user = userService.register(user);
		if(user != null){
			status.setStatus(true);
			status.setMessage("Registration is successful");
			status.setResult(user);
		}else{
			status.setStatus(false);
			status.setMessage("Registration is failed");
			status.setResult(user);
		}
		return status;
	}
	
	@PostMapping(value = YourTimeRestURIConstants.UsersWS.WS_USER_AUTHENDICATE)
	public Status<User>  authendicate(@RequestBody User user) {
		Status<User> status = new Status<User>();

		Optional<User> resultedUser = Optional.ofNullable(userService.authendicate(user));
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
	
	@PostMapping(value=YourTimeRestURIConstants.UsersWS.WS_USER_HOME)
	public Status<Dashboard> home(@RequestBody User user) {
		Status<Dashboard> status = new Status<Dashboard>();
		
		Dashboard dashboard = userService.getDashboardDetails(user);
		status.setResult(dashboard);
		status.setMessage("Loaded dashboard");
		status.setStatus(true);
		return status;
		
	}
	
	@PostMapping(value=YourTimeRestURIConstants.UsersWS.WS_USER_REQUEST_APPOINTMENT)
	public Status<Appointment> requestAppointment(@RequestBody AppointmentDto appointmentRequest) {
		Status<Appointment> status = new Status<Appointment>();
		
		Optional<Appointment> appointmentResult = Optional.ofNullable(userService.requestAppointment(appointmentRequest));
		
		if(appointmentResult.isPresent()) {
			status.setResult(appointmentResult.get());
			status.setStatus(true);
			status.setMessage("Appointment request placed successfully");
		}else {
			status.setMessage("Appointment request could not be placed. Please retry after sometime.");
			status.setStatus(false);
		}
		return status;
		
	}
	
	@PostMapping(value=YourTimeRestURIConstants.UsersWS.WS_USER_APPROVE_APPOINTMENT)
	public Status<Appointment> approveAppointment(@RequestBody Appointment appointment) {
		Status<Appointment> status = new Status<Appointment>();
		
		Optional<Appointment> appointmentResult = Optional.ofNullable(userService.approveAppointment(appointment));
		
		if(appointmentResult.isPresent()) {
			status.setResult(appointmentResult.get());
			status.setStatus(true);
			status.setMessage("Appointment was approved successfully");
		}else {
			status.setMessage("Appointment could not be approved. Please retry after sometime.");
			status.setStatus(false);
		}
		return status;
	}
	
	@PostMapping(value=YourTimeRestURIConstants.UsersWS.WS_USER_DECLINE_APPOINTMENT)
	public Status<Appointment> declineAppointment(@RequestBody Appointment appointment) {
		Status<Appointment> status = new Status<Appointment>();
		
		Optional<Appointment> appointmentResult = Optional.ofNullable(userService.declineAppointment(appointment));
		
		if(appointmentResult.isPresent()) {
			status.setResult(appointmentResult.get());
			status.setStatus(true);
			status.setMessage("Appointment was declined successfully");
		}else {
			status.setMessage("Appointment could not be declined. Please retry after sometime.");
			status.setStatus(false);
		}
		return status;
	}
	
	@PostMapping(value=YourTimeRestURIConstants.UsersWS.WS_USER_CANCEL_APPOINTMENT)
	public Status<Appointment> cancelAppointment(@RequestBody Appointment appointment) {
		Status<Appointment> status = new Status<Appointment>();
		
		Optional<Appointment> appointmentResult = Optional.ofNullable(userService.cancelAppointment(appointment));
		
		if(appointmentResult.isPresent()) {
			status.setResult(appointmentResult.get());
			status.setStatus(true);
			status.setMessage("Appointment was cancelled successfully");
		}else {
			status.setMessage("Appointment could not be cancelled. Please retry after sometime.");
			status.setStatus(false);
		}
		return status;
	}
		
	@PostMapping(value=YourTimeRestURIConstants.UsersWS.WS_USER_RESCHEDULE_APPOINTMENT)
	public Status<Appointment> rescheduleAppointment(@RequestBody AppointmentDto appointmentRequest) {
		Status<Appointment> status = new Status<Appointment>();
		
		Optional<Appointment> appointmentResult = Optional.ofNullable(userService.rescheduleAppointment(appointmentRequest));
		
		if(appointmentResult.isPresent()) {
			status.setResult(appointmentResult.get());
			status.setStatus(true);
			status.setMessage("Appointment was rescheduled successfully");
		}else {
			status.setMessage("Appointment could not be rescheduled. Please retry after sometime.");
			status.setStatus(false);
		}
		return status;
		
	}
	
	@PostMapping(value=YourTimeRestURIConstants.UsersWS.WS_USER_COMPLETE_APPOINTMENT)
	public Status<Appointment> completeAppointment(@RequestBody Appointment appointment) {
		Status<Appointment> status = new Status<Appointment>();
		
		Optional<Appointment> appointmentResult = Optional.ofNullable(userService.cancelAppointment(appointment));
		
		if(appointmentResult.isPresent()) {
			status.setResult(appointmentResult.get());
			status.setStatus(true);
			status.setMessage("Appointment was cancelled successfully");
		}else {
			status.setMessage("Appointment could not be cancelled. Please retry after sometime.");
			status.setStatus(false);
		}
		return status;
	}
	
	@PostMapping(value=YourTimeRestURIConstants.UsersWS.WS_USER_REQUEST_APPOINTMENT)
	public Status<Feedback> feedbackOnAppointment(@RequestBody Feedback feedback) {
		Status<Feedback> status = new Status<Feedback>();
		
		Optional<Feedback> FeedbackResult = Optional.ofNullable(userService.feedbackOnAppointment(feedback));
		
		if(FeedbackResult.isPresent()) {
			status.setResult(FeedbackResult.get());
			status.setStatus(true);
			status.setMessage("Feedback was added to the appointment successfully");
		}else {
			status.setMessage("Feedback could not be added to the appointment. Please retry after sometime.");
			status.setStatus(false);
		}
		return status;
		
	}
}