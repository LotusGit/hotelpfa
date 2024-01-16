package com.example.hotelservicebackend.controllers;

import com.example.hotelservicebackend.entities.Room;
import com.example.hotelservicebackend.init.MongoQueries;
import com.example.hotelservicebackend.repositories.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
@CrossOrigin("http://localhost:4200/")
public class RoomController {
    private final RoomRepository roomRepository;
    private final MongoQueries mongoqueries;

    public RoomController(RoomRepository roomRepository, MongoQueries mongoqueries) {
        this.roomRepository = roomRepository;
        this.mongoqueries = mongoqueries;
    }

    @GetMapping("/getRoom/{id}")
    public Room getRoom(@PathVariable(name = "id") int id) {
        Room room = null;
        if (roomRepository.findById(id).isPresent()) {
            room = roomRepository.findById(id).get();
        }
        return room;
    }
    @GetMapping("/getRooms")
    public List<Room> getRooms(){
        return mongoqueries.getRoomsByDescription();
    }
}
