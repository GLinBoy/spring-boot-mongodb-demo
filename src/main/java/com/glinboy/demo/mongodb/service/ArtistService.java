package com.glinboy.demo.mongodb.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.demo.mongodb.service.dto.ArtistDTO;

public interface ArtistService {

	Page<ArtistDTO> getAllArtist(Pageable pageable);
	
	Optional<ArtistDTO> getArtist(String id);

	ArtistDTO save(ArtistDTO artistDTO);
	
	void deleteArtist(String id);

}
