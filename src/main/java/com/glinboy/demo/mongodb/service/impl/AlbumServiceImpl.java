package com.glinboy.demo.mongodb.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.demo.mongodb.entity.Album;
import com.glinboy.demo.mongodb.repository.AlbumRepository;
import com.glinboy.demo.mongodb.service.AlbumService;
import com.glinboy.demo.mongodb.service.dto.AlbumDTO;
import com.glinboy.demo.mongodb.service.dto.ArtistDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
	
	private final AlbumRepository albumRepository;
	private final ModelMapper mapper;
	
	@Override
	public Page<AlbumDTO> getAllAlbums(Pageable pageable) {
		return albumRepository.findAll(pageable)
				.map(e -> mapper.map(e, AlbumDTO.class));
	}
	
	@Override
	public Optional<AlbumDTO> getAlbum(String id) {
		return albumRepository.findById(id)
				.map(e -> mapper.map(e, AlbumDTO.class));
	}
	
	@Override
	public AlbumDTO saveAlbum(AlbumDTO albumDTO) {
		Album album = mapper.map(albumDTO, Album.class);
		albumRepository.save(album);
		return mapper.map(album, AlbumDTO.class);
	}

}
