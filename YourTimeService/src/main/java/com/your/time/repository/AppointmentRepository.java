package com.your.time.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.your.time.bean.Appointment;
import com.your.time.util.MongodbMapperUtil;

@RepositoryRestResource(collectionResourceRel = MongodbMapperUtil.Collections.APPOINTMENT, path = MongodbMapperUtil.Collections.APPOINTMENT)
public interface AppointmentRepository extends MongoRepository<Appointment, String>{
	
}