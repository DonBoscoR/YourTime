package com.your.time.service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.your.time.dto.AppointmentDto;
import com.your.time.dto.Dashboard;
import com.your.time.entity.Appointment;
import com.your.time.entity.Feedback;
import com.your.time.entity.Service;
import com.your.time.entity.User;
import com.your.time.repository.AppointmentRepository;
import com.your.time.repository.FeedbackRepository;
import com.your.time.repository.ServiceRepository;
import com.your.time.repository.UserServiceRepository;
import com.your.time.repository.UsersRepository;
import com.your.time.util.AppRole;
import com.your.time.util.AppointmentStatus;

@org.springframework.stereotype.Service
public class UserService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	EmailService emailService;

	@Autowired
	private UserServiceRepository userServiceRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
    private MongoTemplate mongoTemplate;

	private static final Logger logger = Logger.getLogger(UserService.class.getName());

	private void clearOTP(User user) {
		user.setOtpString(null);
		user.setOtpValidTill(null);
		usersRepository.save(user);   
	}

	private void generateOneTimePassword(User user){

		byte[] array = new byte[7]; // length is bounded by 7
		new Random().nextBytes(array);
		String OTP = new String(array, Charset.forName("UTF-8"));

		//String encodedOTP = passwordEncoder.encode(OTP);

		user.setOtpString(OTP);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 30);
		user.setOtpValidTill(cal.getTime());

		//usersRepository.save(customer);

		try {
			emailService.sendOTPEmail(user, OTP);
		} catch (UnsupportedEncodingException | MessagingException e) {
			logger.log(Level.SEVERE, "Error while sending OTP mail to user email");
			clearOTP(user);
			e.printStackTrace();
		}
	}

	public User register(User user) {
		if(user != null){

			generateOneTimePassword(user);

			usersRepository.save(user);
		}
		return user;
	}

	public User authendicate(User user) {
		Optional<User> result = usersRepository.findOne(Example.of(user));
		if(!result.isPresent()) {
			return null;
		}
		return user;
	}

	public Dashboard getDashboardDetails(User user) {
		Dashboard dashboard = new Dashboard();
		dashboard.setRole(AppRole.valueOf(user.getRole()));

		long noOfServices = 0l;
		long noOfAppointments = 0l;
		long noOfUsers = 0l;

		if(user.getRole() == AppRole.SYSTEM_ADMIN.name()) {
			noOfServices = serviceRepository.count();
			dashboard.setNoOfServices(noOfServices);

			noOfAppointments = appointmentRepository.count();
			dashboard.setNoOfAppointments(noOfAppointments);

			noOfUsers = usersRepository.count();
			dashboard.setNoOfUsers(noOfUsers);
		}

		Service service = new Service();
		service.setUserId(user.getId());
		noOfServices = serviceRepository.count(Example.of(service));

		Appointment appointment = new Appointment();
		appointment.setScId(user.getId());
		noOfAppointments = appointmentRepository.count(Example.of(appointment));

		return dashboard;
	}

	public Appointment requestAppointment(AppointmentDto booking){

		com.your.time.entity.UserService userService = new com.your.time.entity.UserService();
		userService.setServiceId(booking.getServiceId());

		//Get the spId to send the approval request
		Optional<com.your.time.entity.UserService> userServiceResult = userServiceRepository.findOne(Example.of(userService));

		if(userServiceResult.isPresent()) {
			userService = userServiceResult.get();
			Appointment appointment = new Appointment();
			appointment.setSpId(userService.getUserId());
			appointment.setScId(booking.getUserId());
			appointment.setServiceId(booking.getServiceId());
			appointment.setDay(booking.getDay());
			appointment.setTime(booking.getTime());
			appointment.setDescription(booking.getDescription());
			appointment.setRequestedDate(booking.getRequestedDate());
			appointment.setStatus(AppointmentStatus.NEW);
			appointment.setCreatedOn(new Date());
			return appointmentRepository.save(appointment);
		}
		return null;
	}

	public Appointment approveAppointment(Appointment appointment){

		appointment.setStatus(AppointmentStatus.CONFIRMED);
		appointment.setAcceptedDate(new Date());
		appointment.setUpdatedOn(new Date());
		return appointmentRepository.save(appointment);
		
	}
	
	public Appointment declineAppointment(Appointment appointment){

		appointment.setStatus(AppointmentStatus.DECLINED);
		appointment.setDeclinedDate(new Date());
		appointment.setDeclinedReason(appointment.getDeclinedReason());
		appointment.setUpdatedOn(new Date());
		return appointmentRepository.save(appointment);
		
	}
	
	public Appointment rescheduleAppointment(AppointmentDto booking){
		
		//Cancel the current appointment
		Optional<Appointment> currentAppointmentResult = appointmentRepository.findById(booking.getAppointmentId());
		
		if(currentAppointmentResult.isPresent()) {
			Appointment currentAppointment = currentAppointmentResult.get();
			appointmentRepository.save(currentAppointment);
			
			com.your.time.entity.UserService userService = new com.your.time.entity.UserService();
			userService.setServiceId(booking.getServiceId());

			//Get the spId to send the approval request
			Optional<com.your.time.entity.UserService> userServiceResult = userServiceRepository.findOne(Example.of(userService));

			if(userServiceResult.isPresent()) {
				userService = userServiceResult.get();
				Appointment appointment = new Appointment();
				appointment.setSpId(userService.getUserId());
				appointment.setScId(booking.getUserId());
				appointment.setServiceId(booking.getServiceId());
				appointment.setDay(booking.getDay());
				appointment.setTime(booking.getTime());
				appointment.setDescription(booking.getDescription());
				appointment.setRequestedDate(booking.getRequestedDate());
				appointment.setStatus(AppointmentStatus.RESCHEDULED);
				appointment.setCreatedOn(new Date());
				appointment.setParentId(booking.getAppointmentId());
				return appointmentRepository.save(appointment);
			}
		}else {
			logger.log(Level.SEVERE, "The current appointment is not found/valid.");
		}

		return null;
	}
	
	public Appointment cancelAppointment(Appointment appointment){

		appointment.setStatus(AppointmentStatus.CANCELLED);
		appointment.setCancelledDate(new Date());
		appointment.setCancelledReason(appointment.getDeclinedReason());
		appointment.setUpdatedOn(new Date());
		return appointmentRepository.save(appointment);
		
	}
	
	public Appointment completeAppointment(Appointment appointment){

		appointment.setStatus(AppointmentStatus.COMPLETED);
		appointment.setUpdatedOn(new Date());
		return appointmentRepository.save(appointment);
		
	}
	
	public Feedback feedbackOnAppointment(Feedback feedback){
		
		updateServiceRating(feedback);
		
		updateServiceProviderRating(feedback);
		
		//updateServiceConsumerRating(feedback);
		
		feedback.setCreatedOn(new Date());
		
		return feedbackRepository.save(feedback);
		
	}
	
	private boolean updateServiceRating(Feedback feedback){
		//Calculate service rating
		Optional<Appointment> appointmentResult = appointmentRepository.findById(feedback.getAppointmentId());
		if(appointmentResult.isPresent()) {
			String serviceId = appointmentResult.get().getServiceId();
			
			Appointment appointment = new Appointment();
			appointment.setServiceId(serviceId);
			//find all appointments that are related to this service
			List<Appointment> appointments = appointmentRepository.findAll(Example.of(appointment));
			//Collect all the appointment ids to a list
			List<String> appointmentIds = appointments.stream().map(Appointment::getId).collect(Collectors.toList());
			
			//Create a query to fetch all the feedbacks on the service
			Query query = Query.query(Criteria.where("appointmentId").all(appointmentIds));
			List<Feedback> feedbackOnService = mongoTemplate.find(query, Feedback.class);
			
			if(!feedbackOnService.isEmpty()) {
				//Find the average of all the rating of collected feedback ratings.
				int rating = feedbackOnService.stream().map(Feedback::getRating).reduce(0, Integer::sum)/feedbackOnService.size();
				Optional<Service> serviceResult = serviceRepository.findById(serviceId);
				if(serviceResult.isPresent()) {
					Service service = serviceResult.get();
					service.setRating(rating);
					serviceRepository.save(service);
				}
			}
		}
		return true;
	}
	
	private boolean updateServiceProviderRating(Feedback feedback){
		//Calculate service provider rating
		Optional<Appointment> appointmentResult = appointmentRepository.findById(feedback.getAppointmentId());
		if(appointmentResult.isPresent()) {
			String serviceProviderId = appointmentResult.get().getSpId();
			
			Appointment appointment = new Appointment();
			appointment.setServiceId(serviceProviderId);
			//find all appointments that are related to this service provider
			List<Appointment> appointments = appointmentRepository.findAll(Example.of(appointment));
			//Collect all the appointment ids to a list
			List<String> appointmentIds = appointments.stream().map(Appointment::getId).collect(Collectors.toList());
			
			//Create a query to fetch all the feedbacks on the service provider
			Query query = Query.query(Criteria.where("appointmentId").all(appointmentIds));
			List<Feedback> feedbackOnService = mongoTemplate.find(query, Feedback.class);
			
			if(!feedbackOnService.isEmpty()) {
				//Find the average of all the rating of collected feedback ratings.
				int rating = feedbackOnService.stream().map(Feedback::getRating).reduce(0, Integer::sum)/feedbackOnService.size();
				Optional<User> userResult = usersRepository.findById(serviceProviderId);
				if(userResult.isPresent()) {
					User user = userResult.get();
					user.setRatingAsSp(rating);
					usersRepository.save(user);
				}
			}
		}
		return true;
	}
	
	//TODO: modify to handle the rating concept for the service consumer
	private boolean updateServiceConsumerRating(Feedback feedback){
		//Calculate service rating
		Optional<Appointment> appointmentResult = appointmentRepository.findById(feedback.getAppointmentId());
		if(appointmentResult.isPresent()) {
			String serviceConsumerId = appointmentResult.get().getScId();
			
			Appointment appointment = new Appointment();
			appointment.setServiceId(serviceConsumerId);
			//find all appointments that are related to this service
			List<Appointment> appointments = appointmentRepository.findAll(Example.of(appointment));
			//Collect all the appointment ids to a list
			List<String> appointmentIds = appointments.stream().map(Appointment::getId).collect(Collectors.toList());
			
			//Create a query to fetch all the feedbacks on the service
			Query query = Query.query(Criteria.where("appointmentId").all(appointmentIds));
			List<Feedback> feedbackOnService = mongoTemplate.find(query, Feedback.class);
			
			if(!feedbackOnService.isEmpty()) {
				//Find the average of all the rating of collected feedback ratings.
				int rating = feedbackOnService.stream().map(Feedback::getRating).reduce(0, Integer::sum)/feedbackOnService.size();
				Optional<Service> serviceResult = serviceRepository.findById(serviceConsumerId);
				if(serviceResult.isPresent()) {
					Service service = serviceResult.get();
					service.setRating(rating);
					serviceRepository.save(service);
				}
			}
		}
		return true;
	}

}