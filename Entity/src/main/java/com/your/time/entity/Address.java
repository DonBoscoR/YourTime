package com.your.time.entity;

import lombok.Data;

@Data
public class Address {
	private String addressline1;
    private String addressline2;
    private String country;
    private String state;
    private String zip;
    private String latLang;
}
