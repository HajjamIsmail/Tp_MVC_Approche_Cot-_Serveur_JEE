package com.example.tp4.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RendezVous {
    @Id
    private String id;
    @Temporal(TemporalType.DATE)
    private Date date;
    //Stocker la valeur enum en string :(default value => @Enumerated(EnumType.ORDINAL))
    @Enumerated(EnumType.STRING)
    private statusRDV status;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
