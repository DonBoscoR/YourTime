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
@Document(collection=MongodbMapperUtil.Collections.CONSUMER_EVENT)
public class ConsumerEvent implements Serializable{

	private static final long serialVersionUID = 5095026712729530130L;
	
	@Id
	private String id;
	private String appointmentId;
	private Integer travelReminderMin;
	private String turnReminderMin;
	private boolean requirePaymentReminder;
	private boolean requireNavigation;
	private CommonStatus status;
	
	private Date createdOn;
    private Date updatedOn;
}
