package com.your.time.dto;

import java.io.Serializable;

import com.your.time.util.AppRole;

import lombok.Data;

@Data
public class Dashboard implements Serializable {

	private static final long serialVersionUID = -7396797084270291760L;
	
	AppRole role;
	Long noOfServices;
	Long noOfAppointments;
	Long noOfUsers;
}
