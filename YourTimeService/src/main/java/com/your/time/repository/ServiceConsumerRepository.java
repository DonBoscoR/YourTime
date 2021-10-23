package com.your.time.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.your.time.bean.ServiceConsumer;
import com.your.time.util.MongodbMapperUtil;

@RepositoryRestResource(collectionResourceRel = MongodbMapperUtil.Collections.SERVICE_CONSUMER, path = MongodbMapperUtil.Collections.SERVICE_CONSUMER)
public interface ServiceConsumerRepository extends MongoRepository<ServiceConsumer, String>{
	
}