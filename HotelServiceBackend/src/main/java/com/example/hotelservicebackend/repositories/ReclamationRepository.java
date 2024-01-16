package com.example.hotelservicebackend.repositories;

import com.example.hotelservicebackend.entities.Reclamation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReclamationRepository extends MongoRepository<Reclamation, ObjectId> {
}
