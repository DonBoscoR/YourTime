package com.your.time.bean;

import java.util.Date;

import lombok.Data;

@Data
public class Audit {
	protected Date createdOn;
	protected Date updatedOn;
}
