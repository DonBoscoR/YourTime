package com.your.time.controller;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.your.time.bean.Appointment;
import com.your.time.bean.Status;
import com.your.time.service.BookService;
import com.your.time.util.YourTimeRestURIConstants;


@RestController
public class AppointmentController {

	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private BookService bookService;

	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_BOOK_APPOINTMENT, method = RequestMethod.POST)
	public Status<Appointment> bookAppointment(@RequestBody Appointment booking) {
		Appointment appointment = bookService.save(booking);
		Status<Appointment> status = new Status<Appointment>();

		if(appointment != null){
			status.setStatus(true);
			status.setMessage("Your appointment is successful");
			status.setResult(appointment);
		}else{
			status.setStatus(false);
			status.setMessage("Your appointment could not be succeeded.");
			status.setResult(booking);
		}
		return status;
	}
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_VIEW_APPOINTMENT_DETAILS, method = RequestMethod.POST)
	public Status<Appointment> viewAppointmentDetailsById(@RequestBody Appointment booking) {
		Appointment appointment = bookService.viewAppointmentDetailsById(booking);
		Status<Appointment> status = new Status<Appointment>();

		if(appointment != null){
			status.setStatus(true);
			status.setMessage("Your appointments are loaded");
			status.setResult(appointment);
		}else{
			status.setStatus(false);
			status.setMessage("Your appointments could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_ALL_APPOINTMENTS_BY_CONSUMER, method = RequestMethod.POST)
	public Status<Appointment> getAllAppointmentsByConsumer(@RequestBody Appointment booking) {
		List<Appointment> appointments = bookService.getAllAppointmentsByConsumer(booking);
		Status<Appointment> status = new Status<Appointment>();
		if(appointments != null && appointments.size() > 0){
			status.setStatus(true);
			status.setMessage("Appointments are loaded");
			status.setResults(appointments);
		}else{
			status.setStatus(false);
			status.setMessage("Appointments could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_ALL_ACTIVE_APPOINTMENTS_BY_CONSUMER, method = RequestMethod.POST)
	public Status<Appointment> getAllActiveAppointmentByConsumer(@RequestBody Appointment booking) {
		List<Appointment> appointments = bookService.getAllActiveAppointmentByConsumer(booking);
		Status<Appointment> status = new Status<Appointment>();
		if(appointments != null && appointments.size() > 0){
			status.setStatus(true);
			status.setMessage("Your appointments are loaded");
			status.setResults(appointments);
		}else{
			status.setStatus(false);
			status.setMessage("Your appointments could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_APPOINTMENT_CANCEL_BY_CONSUMER, method = RequestMethod.POST)
	public Status<Appointment> cancelAppointmentByConsumer(@RequestBody Appointment booking) {
		Appointment appointment = bookService.cancelAppointmentByConsumer(booking);
		Status<Appointment> status = new Status<Appointment>();

		if(appointment != null){
			status.setStatus(true);
			status.setMessage("Your appointment is cancelled.");
			status.setResult(appointment);
		}else{
			status.setStatus(false);
			status.setMessage("Your appointment could not be cancelled.");
			status.setResult(booking);
		}
		return status;
	}
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_APPOINTMENT_RESCHEDULE_BY_CONSUMER, method = RequestMethod.POST)
	public Status<Appointment> rescheduleAppointmentByConsumer(@RequestBody Appointment booking) {
		Appointment appointment = bookService.rescheduleAppointmentByConsumer(booking);
		Status<Appointment> status = new Status<Appointment>();

		if(appointment != null){
			status.setStatus(true);
			status.setMessage("Your appointment is rescheduled");
			status.setResult(appointment);
		}else{
			status.setStatus(false);
			status.setMessage("Your appointment could not be rescheduled.");
			status.setResult(booking);
		}
		return status;
	}
	
	/**
	 * ISP Specific Start
	 */
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_CREATE_SCHEDULE_BY_ISP, method = RequestMethod.POST)
	public Status<Appointment> createScheduleByISP(@RequestBody Appointment booking) {
		Appointment schedule = bookService.save(booking);
		Status<Appointment> status = new Status<Appointment>();

		if(schedule != null){
			status.setStatus(true);
			status.setMessage("Your schedule is created.");
			status.setResult(schedule);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedule could not be created.");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_VIEW_SCHEDULE_DETAILS_BY_ISP, method = RequestMethod.POST)
	public Status<Appointment> viewScheduleDetailsById(@RequestBody Appointment booking) {
		Appointment schedule = bookService.viewScheduleDetailsById(booking);
		Status<Appointment> status = new Status<Appointment>();
		if(schedule != null){
			status.setStatus(true);
			status.setMessage("Your schedule details are loaded");
			status.setResult(schedule);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedules could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_ALL_SCHEDULES_BY_ISP, method = RequestMethod.POST)
	public Status<Appointment> getAllSchedulesByISP(@RequestBody Appointment booking) {
		List<Appointment> schedules = bookService.getAllSchedulesByISP(booking);
		Status<Appointment> status = new Status<Appointment>();
		if(schedules != null && schedules.size() > 0){
			status.setStatus(true);
			status.setMessage("Your schedules are loaded");
			status.setResults(schedules);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedules could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_ALL_ACTIVE_SCHEDULES_BY_ISP, method = RequestMethod.POST)
	public Status<Appointment> getAllActiveSchedulesByISP(@RequestBody Appointment booking) {
		List<Appointment> schedules = bookService.getAllActiveSchedulesByISP(booking);
		Status<Appointment> status = new Status<Appointment>();
		if(schedules != null && schedules.size() > 0){
			status.setStatus(true);
			status.setMessage("Your schedules are loaded");
			status.setResults(schedules);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedules could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_ALL_SCHEDULES_DONE_BY_ISP, method = RequestMethod.POST)
	public Status<Appointment> getAllSchedulesDoneByISP(@RequestBody Appointment booking) {
		List<Appointment> schedules = bookService.getAllSchedulesDoneByISP(booking);
		Status<Appointment> status = new Status<Appointment>();
		if(schedules != null && schedules.size() > 0){
			status.setStatus(true);
			status.setMessage("Your schedules are loaded");
			status.setResults(schedules);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedules could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_ALL_ACTIVE_SCHEDULES_DONE_BY_ISP, method = RequestMethod.POST)
	public Status<Appointment> getAllActiveSchedulesDoneByISP(@RequestBody Appointment booking) {
		List<Appointment> schedules = bookService.getAllActiveSchedulesDoneByISP(booking);
		Status<Appointment> status = new Status<Appointment>();
		if(schedules != null && schedules.size() > 0){
			status.setStatus(true);
			status.setMessage("Your schedules are loaded");
			status.setResults(schedules);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedules could not be loaded");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_SCHEDULE_CANCEL_BY_ISP, method = RequestMethod.POST)
	public Status<Appointment> cancelScheduleByISP(@RequestBody Appointment booking) {
		Appointment schedule = bookService.cancelScheduleByISP(booking);
		Status<Appointment> status = new Status<Appointment>();

		if(schedule != null){
			status.setStatus(true);
			status.setMessage("Your schedule is cancelled.");
			status.setResult(schedule);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedule could not be cancelled.");
			status.setResult(booking);
		}
		return status;
	}
	
	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_SCHEDULE_CONFIRM_BY_ISP, method = RequestMethod.POST)
	public Status<Appointment> confirmScheduleByISP(@RequestBody Appointment booking) {
		Appointment schedule = bookService.confirmScheduleByISP(booking);
		Status<Appointment> status = new Status<Appointment>();

		if(schedule != null){
			status.setStatus(true);
			status.setMessage("Your schedule is confirmed.");
			status.setResult(schedule);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedule could not be confirmed.");
			status.setResult(booking);
		}
		return status;
	}

	@RequestMapping(value=YourTimeRestURIConstants.BookingWS.WS_SCHEDULE_RESCHEDULE_BY_ISP, method = RequestMethod.POST)
	public Status<Appointment> rescheduleScheduleByISP(@RequestBody Appointment booking) {
		Appointment schedule = bookService.rescheduleScheduleByISP(booking);
		Status<Appointment> status = new Status<Appointment>();

		if(schedule != null){
			status.setStatus(true);
			status.setMessage("Your schedule is cancelled.");
			status.setResult(schedule);
		}else{
			status.setStatus(false);
			status.setMessage("Your schedule could not be cancelled.");
			status.setResult(booking);
		}
		return status;
	}
}