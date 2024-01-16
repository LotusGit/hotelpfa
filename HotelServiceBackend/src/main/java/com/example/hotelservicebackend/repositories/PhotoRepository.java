package com.example.hotelservicebackend.repositories;

import com.example.hotelservicebackend.entities.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {
}

