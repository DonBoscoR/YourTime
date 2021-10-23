package com.your.time.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.your.time.bean.MasterData;
import com.your.time.util.MongodbMapperUtil;

@RepositoryRestResource(collectionResourceRel = MongodbMapperUtil.Collections.MASTER_DATA, path = MongodbMapperUtil.Collections.MASTER_DATA)
public interface MasterDataRepository extends MongoRepository<MasterData, String>{
	public List<MasterData> findByType(String type);
}