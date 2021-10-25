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
@Document(collection=MongodbMapperUtil.Collections.SERVICE_TIMING)
public class ServiceTiming implements Serializable {
	
	private static final long serialVersionUID = 7103731279661401564L;
	
	@Id
	private String id;
	private String spId;
	private String sun;
	private String mon;
	private String tue;
	private String wed;
	private String thu;
	private String fri;
	private String sat;
	private CommonStatus status;
	
	private Date createdOn;
    private Date updatedOn;
}
