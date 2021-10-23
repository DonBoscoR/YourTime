package com.your.time.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.your.time.bean.ConsumerEvent;
import com.your.time.util.MongodbMapperUtil;

@RepositoryRestResource(collectionResourceRel = MongodbMapperUtil.Collections.CONSUMER_EVENT, path = MongodbMapperUtil.Collections.CONSUMER_EVENT)
public interface ConsumerEventRepository extends MongoRepository<ConsumerEvent, String>{
	
}