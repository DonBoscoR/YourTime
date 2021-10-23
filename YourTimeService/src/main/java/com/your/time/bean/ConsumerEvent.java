package com.your.time.bean;

import java.io.Serializable;

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
@Document(collection=MongodbMapperUtil.Collections.CONSUMER_EVENT)
public class ConsumerEvent extends Audit implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String appointmentId;
	private Integer travelReminderMin;
	private String turnReminderMin;
	private boolean requirePaymentReminder;
	private boolean requireNavigation;
}
