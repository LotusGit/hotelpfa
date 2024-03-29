package com.example.hotelservicebackend.controllers;

import com.example.hotelservicebackend.entities.Photo;
import com.example.hotelservicebackend.repositories.PhotoRepository;
import com.example.hotelservicebackend.services.PhotoService;
import com.example.hotelservicebackend.services.SequenceGeneratorService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/photo")
@CrossOrigin("http://localhost:4200")
public class PhotoControllers {
    public final PhotoService photoService;
    public final PhotoRepository photoRepository;
    public final SequenceGeneratorService sequenceGeneratorService;

    public PhotoControllers(PhotoRepository photoRepository, PhotoService photoService, SequenceGeneratorService sequenceGeneratorService) {
        this.photoRepository = photoRepository;
        this.photoService = photoService;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("title") String title,
                           @RequestParam("image") MultipartFile image)
            throws IOException {
        String id=photoService.addPhoto(title,image);
        return "redirect:/photos/" + id;
    }
    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable String id, Model model) {
        Photo photo = photoService.getPhoto(id);
        model.addAttribute("title", photo.getTitle());
        model.addAttribute("image",
                Base64.getEncoder().encodeToString(photo.getImage().getData()));
        return photo;
    }

}
