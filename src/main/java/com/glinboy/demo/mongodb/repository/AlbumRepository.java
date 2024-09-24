package com.glinboy.demo.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.glinboy.demo.mongodb.entity.Album;

public interface AlbumRepository extends MongoRepository<Album, String> {

}
