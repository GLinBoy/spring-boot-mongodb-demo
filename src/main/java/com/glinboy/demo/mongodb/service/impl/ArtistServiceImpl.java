package com.glinboy.demo.mongodb.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.demo.mongodb.entity.Artist;
import com.glinboy.demo.mongodb.repository.ArtistRepository;
import com.glinboy.demo.mongodb.service.ArtistService;
import com.glinboy.demo.mongodb.service.dto.ArtistDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

	private final ArtistRepository artistRepository;
	private final ModelMapper mapper;

	@Override
	public Page<ArtistDTO> getAllArtist(Pageable pageable) {
		return artistRepository.findAll(pageable)
				.map(e -> mapper.map(e, ArtistDTO.class));
	}
	
	public Optional<ArtistDTO> getArtist(String id) {
		return artistRepository.findById(id)
				.map(e -> mapper.map(e, ArtistDTO.class));
	}

	@Override
	public ArtistDTO save(ArtistDTO artistDTO) {
		Artist artist = mapper.map(artistDTO, Artist.class);
		artistRepository.save(artist);
		return mapper.map(artist, ArtistDTO.class);
	}

}
