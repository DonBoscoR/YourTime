package com.your.time.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.your.time.entity.User;
import com.your.time.util.MongodbMapperUtil;

@RepositoryRestResource(collectionResourceRel = MongodbMapperUtil.Collections.USER, path = MongodbMapperUtil.Collections.USER)
public interface UsersRepository extends MongoRepository<User, String>{

	//public User findByUsername(String username);	
}