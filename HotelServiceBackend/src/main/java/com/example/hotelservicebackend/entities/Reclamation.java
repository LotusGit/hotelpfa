package com.example.hotelservicebackend.entities;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document

public class Reclamation {

    @Id
    private ObjectId id;
    @DBRef
    @Indexed
    private Compte_client client ;
    @NotEmpty
    @NonNull
    private String description ;
}
