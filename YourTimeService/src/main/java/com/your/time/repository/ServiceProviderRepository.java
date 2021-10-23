package com.your.time.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.your.time.bean.ServiceProvider;
import com.your.time.util.MongodbMapperUtil;

@RepositoryRestResource(collectionResourceRel = MongodbMapperUtil.Collections.SERVICE_PROVIDER, path = MongodbMapperUtil.Collections.SERVICE_PROVIDER)
public interface ServiceProviderRepository extends MongoRepository<ServiceProvider, String>{

}