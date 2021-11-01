package com.your.time.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.your.time.entity.UserService;
import com.your.time.util.MongodbMapperUtil;

@RepositoryRestResource(collectionResourceRel = MongodbMapperUtil.Collections.USER_SERVICE, path = MongodbMapperUtil.Collections.USER_SERVICE)
public interface UserServiceRepository extends MongoRepository<UserService, String>{

}