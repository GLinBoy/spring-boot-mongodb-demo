package com.glinboy.demo.mongodb.service.dto;

public record AlbumDTO(
		String id,
		Long artistId,
		String albumTitle,
		String genre,
		String yearOfPub,
		Short numOfTracks,
		Long numOfSales,
		Float rollingStoneCritic,
		Float mtvCritic,
		Float musicManiacCritic
) {}
