package com.example.hotelservicebackend.repositories;

import com.example.hotelservicebackend.entities.Compte_client;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200/")
public interface Compte_clientRepository extends MongoRepository<Compte_client, ObjectId> {
    @Query(value = "{ 'email' : ?0, 'password' : ?1 }")
    Compte_client findByEmailAndPassword(String email, String password);
    @Query(value = "{ 'email' : ?0 }")
    Compte_client findByEmail(String email);


}
