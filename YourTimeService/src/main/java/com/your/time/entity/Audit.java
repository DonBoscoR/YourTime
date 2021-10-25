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
@Document(collection=MongodbMapperUtil.Collections.AUDIT)
public class Audit implements Serializable{
	
	private static final long serialVersionUID = 2831264304948212592L;
	
	@Id
	private String id;
	private String userId;
	private String userRole;
	private String action;
	private String affectedEntity;
	private String entityId;
	private CommonStatus status;
	
	private Date createdOn;
	private Date updatedOn;
}
