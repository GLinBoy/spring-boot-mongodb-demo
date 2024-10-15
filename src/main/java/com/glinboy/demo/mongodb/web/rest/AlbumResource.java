package com.glinboy.demo.mongodb.web.rest;

import com.glinboy.demo.mongodb.service.AlbumService;
import com.glinboy.demo.mongodb.service.dto.AlbumDTO;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

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

}
