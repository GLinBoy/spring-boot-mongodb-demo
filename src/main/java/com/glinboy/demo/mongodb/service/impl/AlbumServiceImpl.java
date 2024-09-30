package com.glinboy.demo.mongodb.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.demo.mongodb.repository.AlbumRepository;
import com.glinboy.demo.mongodb.service.AlbumService;
import com.glinboy.demo.mongodb.service.dto.AlbumDTO;

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

}
