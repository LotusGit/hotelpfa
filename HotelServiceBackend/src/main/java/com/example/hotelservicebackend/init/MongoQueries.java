package com.example.hotelservicebackend.init;

import com.example.hotelservicebackend.entities.Room;
import com.example.hotelservicebackend.repositories.RoomRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Component
@CrossOrigin("*")
public class MongoQueries {

    final MongoTemplate mongoTemplate;
    final RoomRepository roomRepository;

    public MongoQueries(MongoTemplate mongoTemplate, RoomRepository roomRepository) {
        this.mongoTemplate = mongoTemplate;
        this.roomRepository = roomRepository;
    }

    public List<String> getDistinctRooms(){
        return  mongoTemplate.query(Room.class).distinct("description").as(String.class).all();
    }

    public List<Room> getRoomsByDescription(){
        List<String> descriptions=getDistinctRooms();
        List<Room> rooms = new ArrayList<>();
        for (String description : descriptions) {
            Room room = roomRepository.randoms(description).getMappedResults().stream().findFirst().orElse(null);
            rooms.add(room);
        }
        return rooms;
    }
}
