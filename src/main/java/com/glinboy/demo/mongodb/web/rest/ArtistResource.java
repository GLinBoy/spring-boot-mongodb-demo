package com.glinboy.demo.mongodb.web.rest;

import java.net.URI;

import org.springdoc.core.converters.models.PageableAsQueryParam;
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
	@PageableAsQueryParam
	public ResponseEntity<Page<ArtistDTO>> getAllArtist(@Parameter(hidden = true) Pageable pageable) {
		return ResponseEntity.ok(artistService.getAllArtist(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ArtistDTO> getArtist(@PathVariable String id) {
		return artistService.getArtist(id)
			.map(ResponseEntity::ok)
			.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<ArtistDTO> saveArtist(@RequestBody ArtistDTO artistDTO,
			HttpServletRequest request) {
		ArtistDTO savedArtistDTO = artistService.saveArtist(artistDTO);
		URI location = URI.create(String.format("%s/%s", request.getRequestURI(), savedArtistDTO.getId()));
		return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).body(savedArtistDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteArtist(@PathVariable String id) {
		artistService.deleteArtist(id);
		return ResponseEntity.noContent().build();
	}
}
