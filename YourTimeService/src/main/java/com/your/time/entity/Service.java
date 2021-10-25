package com.your.time.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.your.time.util.CommonStatus;
import com.your.time.util.MongodbMapperUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection=MongodbMapperUtil.Collections.SERVICE)
public class Service implements Serializable{

	private static final long serialVersionUID = 1962343282635516467L;
	
	@Id
    private String id;
	private String userId;
    private String name;
    private String OfficialName;
    private String displayName;
    private Address address;
    
    private String category;
    private Integer minAge;
    private String  gender;
    private Double  fee;
    
    private String contactPerson;
    private String contactNumber;
    private String contactEmail;
    
    private Date verifiedDate;
    private Integer rating;
    
    private String otpString;
    private Date   otpValidTill;
    
    private CommonStatus status;
    
    private Date createdOn;
    private Date updatedOn;
}