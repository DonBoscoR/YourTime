package com.your.time.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.your.time.bean.Appointment;
import com.your.time.repository.AppointmentRepository;
import com.your.time.util.AppointmentStatus;

@Service
public class BookService {
	
	@Autowired
	AppointmentRepository bookingRepository;

    private static final Logger logger = Logger.getLogger(BookService.class.getName());
    
    public Appointment save(Appointment booking){
    	return bookingRepository.save(booking);
    }

	public Appointment viewAppointmentDetailsById(Appointment booking) {
		return bookingRepository.findById(booking.getId()).get();
	}

	public List<Appointment> getAllAppointmentsByConsumer(Appointment booking) {
		Query query = new Query();
		//query.addCriteria(Criteria.where(MongodbMapperUtil.Booking.username).is(booking.getUsername()));
		List<Appointment> list  = null;//bookingRepository.findByQuery(query, Booking.class);
		for (Appointment obj : list) {
			//obj.getWaitTime();
		}
		return list;
	}
	
	public List<Appointment> getAllActiveAppointmentByConsumer(Appointment booking) {
		Query query = new Query();
		List<AppointmentStatus> statuses = new ArrayList<>();
		statuses.add(AppointmentStatus.NEW);
		statuses.add(AppointmentStatus.BOOKED);
		statuses.add(AppointmentStatus.CONFIRMED);
		statuses.add(AppointmentStatus.RESCHEDULED);
		//query.addCriteria(Criteria.where(MongodbMapperUtil.Booking.username).is(booking.getUsername()).andOperator(Criteria.where(MongodbMapperUtil.Booking.status).in(statuses)));
		List<Appointment> list  = null;//commonDAO.findByQuery(query, Booking.class);
		for (Appointment obj : list) {
			//obj.getWaitTime();
		}
		return list;
	}

	public Appointment cancelAppointmentByConsumer(Appointment booking) {
		//booking.setStatus(BookingStatus.CANCEL.name());
		return bookingRepository.save(booking);
	}

	public Appointment rescheduleAppointmentByConsumer(Appointment booking) {
		//booking.setStatus(BookingStatus.RESCHEDULED.name());
		return bookingRepository.save(booking);
	}
	/**
	 * ISP Specific Methods start
	 */
	public Appointment viewScheduleDetailsById(Appointment booking) {
		return null;//bookRepositoryDAO.findById(booking.getId()).get();
	}

	public List<Appointment> getAllSchedulesByISP(Appointment booking) {
		Query query = new Query();
		//query.addCriteria(Criteria.where(MongodbMapperUtil.Booking.serviceProviderId).is(booking.getServiceProviderId()));
		List<Appointment> list  = null;//commonDAO.findByQuery(query, Booking.class);
		return list;
	}
	
	public List<Appointment> getAllActiveSchedulesByISP(Appointment booking) {
		Query query = new Query();
		List<AppointmentStatus> statuses = new ArrayList<>();
		statuses.add(AppointmentStatus.CONFIRMED);
		//query.addCriteria(Criteria.where(MongodbMapperUtil.Booking.serviceProviderId).is(booking.getServiceProviderId()).andOperator(Criteria.where(MongodbMapperUtil.Booking.status).in(statuses)));
		List<Appointment> list  = null;//commonDAO.findByQuery(query, Booking.class);
		return list;
	}
	
	public List<Appointment> getAllSchedulesDoneByISP(Appointment booking) {
		Query query = new Query();
		//query.addCriteria(Criteria.where(MongodbMapperUtil.Booking.serviceProviderId).is(booking.getServiceProviderId()).andOperator(Criteria.where(MongodbMapperUtil.Booking.createdBy).in(booking.getServiceProviderId())));
		List<Appointment> list  = null;//commonDAO.findByQuery(query, Booking.class);
		return list;
	}
	
	public List<Appointment> getAllActiveSchedulesDoneByISP(Appointment booking) {
		Query query = new Query();
		List<AppointmentStatus> statuses = new ArrayList<>();
		statuses.add(AppointmentStatus.NEW);
		statuses.add(AppointmentStatus.BOOKED);
		statuses.add(AppointmentStatus.CONFIRMED);
		statuses.add(AppointmentStatus.RESCHEDULED);
		//query.addCriteria(Criteria.where(MongodbMapperUtil.Booking.serviceProviderId).is(booking.getServiceProviderId()).andOperator(Criteria.where(MongodbMapperUtil.Booking.status).in(statuses)).andOperator(Criteria.where(MongodbMapperUtil.Booking.createdBy).in(booking.getServiceProviderId())));
		List<Appointment> list  = null;//commonDAO.findByQuery(query, Booking.class);
		return list;
	}

	public Appointment cancelScheduleByISP(Appointment booking) {
		//booking.setStatus(BookingStatus.CANCEL.name());
		return bookingRepository.save(booking);
	}
	
	public Appointment confirmScheduleByISP(Appointment booking) {
		//booking.setStatus(BookingStatus.CONFIRMED.name());
		return bookingRepository.save(booking);
	}

	public Appointment rescheduleScheduleByISP(Appointment booking) {
		//booking.setStatus(BookingStatus.RESCHEDULED.name());
		return bookingRepository.save(booking);
	}
	
}