package com.your.time.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.your.time.util.AppointmentStatus;
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
@Document(collection=MongodbMapperUtil.Collections.APPOINTMENT)
public class Appointment implements Serializable{

	private static final long serialVersionUID = 3728852768802389285L;
	
	@Id
	private String id;
	private String spId;
    private String scId;
    private String serviceId;
	private LocalDate day;
	private LocalTime time;
	private AppointmentStatus status;
	private Date requestedDate;
	private Date acceptedDate;
	private Date declinedDate;
	private Date cancelledDate;
	private String description;
	private String declinedReason;
	private String cancelledReason;	
	private String parentId;
	private CommonStatus recStatus;
	
	private Date createdOn;
    private Date updatedOn;
}