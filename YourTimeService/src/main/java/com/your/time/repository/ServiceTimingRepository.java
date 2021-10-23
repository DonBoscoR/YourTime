package com.your.time.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.your.time.bean.ServiceTiming;
import com.your.time.util.MongodbMapperUtil;

@RepositoryRestResource(collectionResourceRel = MongodbMapperUtil.Collections.SERVICE_TIMING, path = MongodbMapperUtil.Collections.SERVICE_TIMING)
public interface ServiceTimingRepository extends MongoRepository<ServiceTiming, String>{
	
}