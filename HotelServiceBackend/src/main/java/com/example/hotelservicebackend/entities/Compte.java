package com.example.hotelservicebackend.entities;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;

@Data @NoArgsConstructor @AllArgsConstructor @CompoundIndex(def = "{'email':1}",unique = true)
public abstract class Compte {
    @Id
    public ObjectId id;
    public String nom;
    public  String prenom;
    @NonNull
    public String email;
    @NonNull
    public String password;
    public String sexe;
}
