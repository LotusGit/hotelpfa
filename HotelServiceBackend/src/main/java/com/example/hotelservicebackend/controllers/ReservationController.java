package com.example.hotelservicebackend.controllers;

import com.example.hotelservicebackend.entities.Reservation;
import com.example.hotelservicebackend.entities.Room;
import com.example.hotelservicebackend.repositories.Compte_clientRepository;
import com.example.hotelservicebackend.repositories.ReservationRepository;
import com.example.hotelservicebackend.repositories.RoomRepository;
import com.example.hotelservicebackend.services.SmtpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequestMapping("/service")
@RestController
@CrossOrigin("http://localhost:4200/")

public class ReservationController {

    private final ReservationRepository reservationRepository;

    private final RoomRepository roomRepository;
    private final Compte_clientRepository clientRepository;

    private final SmtpService smtpService;


    public ReservationController(ReservationRepository reservationRepository, RoomRepository roomRepository, Compte_clientRepository clientRepository, SmtpService smtpService) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;
        this.smtpService = smtpService;
    }


    @GetMapping("/getrooms")
    public List<Reservation> reservationList(){
        return reservationRepository.findAll();
    }

    @PostMapping("/MakeReservation")
    public ResponseEntity<?> makeReservation(@RequestBody Reservation reservation){

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            Room status=roomRepository.random().getMappedResults().stream().findFirst().orElse(null);
            assert status != null;
            status.setState(true);
            reservation.setClient(clientRepository.findByEmail(reservation.getClient().getEmail()));
            reservation.setRoom(status);
            String message ="Bonjour, "+ reservation.getClient().getNom() +" "+reservation.getClient().getPrenom()+"\n\n merci de faire une reservation depuis la date"+reservation
                    .getDateDeDebut()+"a la date:"+reservation.getDateDeFin()+".\n Respectuesement\nHotel ...";
            reservation.setDateDeReservation(myDateObj.format(timeFormatter));
            reservation.setDateDeDebut(reservation.getDateDeDebut().formatted(timeFormatter));
            reservation.setDateDeFin(reservation.getDateDeFin().formatted(timeFormatter));
            reservationRepository.save(reservation);
            roomRepository.save(status);
            smtpService.sendSimpleMessage(reservation.getClient().getEmail(), "reservation", message);
            return ResponseEntity.ok("reservation has been done with success");
        }
        catch(Exception e){
            return ResponseEntity.ok("Deja reserve"+e);
        }

    }
}
