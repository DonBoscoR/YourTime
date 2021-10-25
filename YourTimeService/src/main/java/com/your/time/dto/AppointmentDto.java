package com.your.time.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.your.time.util.AppointmentStatus;

import lombok.Data;

@Data
public class AppointmentDto implements Serializable {

	private static final long serialVersionUID = 3545531930756749169L;
	
	private String userId;
	private String serviceId;
	private LocalDate day;
	private LocalTime time;
	private String description;
	private Date requestedDate;
	private AppointmentStatus status;
	private String appointmentId;
}
