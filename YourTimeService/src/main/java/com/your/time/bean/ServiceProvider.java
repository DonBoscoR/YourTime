package com.your.time.bean;

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
@Document(collection=MongodbMapperUtil.Collections.SERVICE_PROVIDER)
public class ServiceProvider extends Audit implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    private String id;
	private String spId;
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
}