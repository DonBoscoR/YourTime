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
@Document(collection=MongodbMapperUtil.Collections.USER)
public class User implements Serializable{

	private static final long serialVersionUID = -2346264990978033538L;
	
	@Id
    private String id;
	private String firstname;
	private String lastname;
    private String password;
    private String confirmPassword;
    private Address address;
    private String email;
    private String phoneNumber;
    private String otpString;
    private Date   otpValidTill;
    private Date verifiedOn;
    private String role;
    private Integer ratingAsSp;
    private Integer ratingAsSc;
    private CommonStatus status;

    private Date lastActive;
    private Date createdOn;
    private Date updatedOn;
}