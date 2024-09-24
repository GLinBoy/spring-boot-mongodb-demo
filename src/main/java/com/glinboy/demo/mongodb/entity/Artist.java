package com.glinboy.demo.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("artist")
public class Artist {
	
	@Id
	private String id;
	private String realName;
	private String artName;
	private String role;
	private String yearOfBirth;
	private String country;
	private String city;
	private String email;
	private String zipCode;
}
