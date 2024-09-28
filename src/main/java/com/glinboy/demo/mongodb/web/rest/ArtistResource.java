package com.glinboy.demo.mongodb.web.rest;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.glinboy.demo.mongodb.service.ArtistService;
import com.glinboy.demo.mongodb.service.dto.ArtistDTO;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/artists")
public class ArtistResource {

	private final ArtistService artistService;

	@GetMapping
	public ResponseEntity<Page<ArtistDTO>> getAllArtist(@Parameter(hidden = true) Pageable pageable) {
		return ResponseEntity.ok(artistService.getAllArtist(pageable));
	}

	@PostMapping
	public ResponseEntity<ArtistDTO> saveArtist(@RequestBody ArtistDTO artistDTO,
			HttpServletRequest request) {
		ArtistDTO savedArtistDTO = artistService.save(artistDTO);
		URI location = URI.create(String.format("%s/%s", request.getRequestURI(), savedArtistDTO.getId()));
		return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).body(savedArtistDTO);
	}
}
