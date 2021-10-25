package com.your.time.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.your.time.entity.MasterData;
import com.your.time.repository.MasterDataRepository;

@Component
public class MasterDataService {

    @Autowired
    private MasterDataRepository masterDataRepository;
    
    private static final Logger logger = Logger.getLogger(MasterDataService.class.getName());
    
    public List<MasterData> findByActiveType(String type){
    	return masterDataRepository.findByType(type);
    }
    
    public List<MasterData> findAll(){
    	return masterDataRepository.findAll();
    }
}