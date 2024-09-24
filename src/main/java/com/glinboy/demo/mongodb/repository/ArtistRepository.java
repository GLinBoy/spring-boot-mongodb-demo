package com.glinboy.demo.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.glinboy.demo.mongodb.entity.Artist;

public interface ArtistRepository extends MongoRepository<Artist, String> {

}
