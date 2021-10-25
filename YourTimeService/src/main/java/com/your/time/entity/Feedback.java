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
@Document(collection=MongodbMapperUtil.Collections.FEEDBACK)
public class Feedback implements Serializable{

	private static final long serialVersionUID = 294918889577680480L;
	
	@Id
	private String id;
	private String appointmentId;
	private String comment;
	private Integer rating;
	private CommonStatus status;
	
	private Date createdOn;
    private Date updatedOn;
}