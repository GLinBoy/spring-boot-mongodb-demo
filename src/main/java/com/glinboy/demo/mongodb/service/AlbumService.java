package com.glinboy.demo.mongodb.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.demo.mongodb.service.dto.AlbumDTO;

public interface AlbumService {
	
	Page<AlbumDTO> getAllAlbums(Pageable pageable);
	
	Optional<AlbumDTO> getAlbum(String id);
	
	AlbumDTO saveAlbum(AlbumDTO albumDTO);

}
