package com.example.hotelservicebackend.repositories;

import com.example.hotelservicebackend.entities.Room;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,Integer> {
    @Aggregation(pipeline = {"{$match: {state: false}}","{$sample:{size:1}}"})
    AggregationResults<Room> random();

    @Aggregation(pipeline = {"{$match: {description: ?0,state: false}}","{$sample:{size:1}}"})
    AggregationResults<Room> randoms(String desc);


}
