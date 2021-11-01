package com.your.time.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.your.time.entity.Service;
import com.your.time.util.MongodbMapperUtil;

@RepositoryRestResource(collectionResourceRel = MongodbMapperUtil.Collections.SERVICE, path = MongodbMapperUtil.Collections.SERVICE)
public interface ServiceRepository extends MongoRepository<Service, String>{
}