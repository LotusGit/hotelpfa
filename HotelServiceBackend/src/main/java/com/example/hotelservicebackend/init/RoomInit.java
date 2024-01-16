package com.example.hotelservicebackend.init;

import com.example.hotelservicebackend.entities.Room;
import com.example.hotelservicebackend.repositories.PhotoRepository;
import com.example.hotelservicebackend.repositories.ReservationRepository;
import com.example.hotelservicebackend.repositories.RoomRepository;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class RoomInit {
    private final RoomRepository roomRepositories;
    private final PhotoRepository photoRepository;
    private final ReservationRepository reservationRepository;
    public RoomInit(RoomRepository roomRepositories, PhotoRepository photoRepository, ReservationRepository reservationRepository) {
        this.roomRepositories = roomRepositories;
        this.photoRepository = photoRepository;
        this.reservationRepository = reservationRepository;
    }

    @PostConstruct
    public void createRooms() {
        roomRepositories.deleteAll();
        reservationRepository.deleteAll();
        String description="A room with two beds and beach view";
        for (int i = 1; i <=10; i++) {
            Room room = new Room(i, "Room with beach view", false, 200.0, description, null,photoRepository.findById("1").orElse(null));
            roomRepositories.save(room);
        }
        for (int i = 11; i <=21; i++) {
            Room room = new Room(i, "chambre standard ", false, 400.0, "La chambre standard comprend 1 lit double ou 2 lits jumeaux, 2 tables de chevet, un bureau et une chaise. La chambre est meublée de moquette, d'un mobilier tendance et d'un balcon. Notre salle de bain en verre ultramoderne est équipée d'un sèche-cheveux, d'un rasage grossissant et d'un miroir de maquillage ainsi que de toutes les commodités dont vous pourriez avoir besoin pendant votre séjour.", null,photoRepository.findById("1").orElse(null));
            roomRepositories.save(room);
        }
        for (int i = 22; i <=30; i++) {
            Room room = new Room(i, "chambre lux", false, 400.0, "Toutes nos chambres sont élégamment meublées avec des meubles faits à la main et comprennent une salle de bains luxueuse avec articles de toilette gratuits, une télévision à écran plat LCD, un plateau/bouilloire, un ventilateur, un sèche-cheveux et les meilleurs draps et serviettes. serviettes d'un blanc pur.", null,photoRepository.findById("1").orElse(null));
            roomRepositories.save(room);
        }
        /*this is a comment /* sadsdasd*/
    }
}
