package com.glinboy.demo.mongodb.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {
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
