package com.glinboy.demo.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("album")
public class Album {
	
	@Id
	private String id;
	private Long artistId;
	private String albumTitle;
	private String genre;
	private String yearOfPub;
	private Short numOfTracks;
	private Long numOfSales;
	private Float rollingStoneCritic;
	private Float mtvCritic;
	private Float musicManiacCritic;
}
