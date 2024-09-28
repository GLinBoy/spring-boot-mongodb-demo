package com.glinboy.demo.mongodb.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDTO {
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
