package com.your.time.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
public class User extends Audit implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    private String id;
	private String firstname;
	private String lastname;
    private String password;
    private String confirmPassword;
    private String email;
    private String otpString;
    private Date   otpValidTill;
    private Address address;
    private Date lastActive;
    private Integer rating;
}