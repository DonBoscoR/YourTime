package com.your.time.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.your.time.bean.Feedback;
import com.your.time.util.MongodbMapperUtil;

@RepositoryRestResource(collectionResourceRel = MongodbMapperUtil.Collections.FEEDBACK, path = MongodbMapperUtil.Collections.FEEDBACK)
public interface FeedbackRepository extends MongoRepository<Feedback, String>{
	
}