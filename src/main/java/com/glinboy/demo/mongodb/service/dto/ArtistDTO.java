package com.glinboy.demo.mongodb.service.dto;

public record ArtistDTO(
		String id,
		String realName,
		String artName,
		String role,
		String yearOfBirth,
		String country,
		String city,
		String email,
		String zipCode
) {}
