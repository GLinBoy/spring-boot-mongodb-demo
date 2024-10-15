package com.glinboy.demo.mongodb.web.rest;

import com.glinboy.demo.mongodb.service.AlbumService;
import com.glinboy.demo.mongodb.service.dto.AlbumDTO;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/albums")
public class AlbumResource {

	private final AlbumService albumService;

	@GetMapping
	@PageableAsQueryParam
	public ResponseEntity<Page<AlbumDTO>> getAllAlbum(@Parameter(hidden = true) Pageable pageable) {
		return ResponseEntity.ok(albumService.getAllAlbums(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<AlbumDTO> getAlbum(@PathVariable String id) {
		return albumService.getAlbum(id)
			.map(ResponseEntity::ok)
			.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<AlbumDTO> saveAlbum(@RequestBody AlbumDTO albumDTO,
																						HttpServletRequest request) {
		AlbumDTO savedAlbumDTO = albumService.saveAlbum(albumDTO);
		URI location = URI.create(String.format("%s/%s", request.getRequestURI(), savedAlbumDTO.getId()));
		return ResponseEntity.created(location)
			.contentType(MediaType.APPLICATION_JSON)
			.body(savedAlbumDTO);
	}

	@PutMapping
	public ResponseEntity<AlbumDTO> updateAlbum(@RequestBody AlbumDTO albumDTO) {
		return ResponseEntity.ok(albumService.updateAlbum(albumDTO));
	}

}
