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
@Document(collection=MongodbMapperUtil.Collections.SERVICE_CONSUMER)
public class ServiceConsumer extends Audit implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    private String id;
    private String firstname;
    private String lastname;
    private String  gender;
    private Integer age;
    private String displayName;
    private Address address;
    
    private String phoneNumber;
    private String email;
    
    private Date verifiedDate;
    private Integer rating;
    
    private String otpString;
    private Date   otpValidTill;
    
    private CommonStatus status;
}