package com.example.hotelservicebackend.repositories;

import com.example.hotelservicebackend.entities.Reservation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, ObjectId> {
}
