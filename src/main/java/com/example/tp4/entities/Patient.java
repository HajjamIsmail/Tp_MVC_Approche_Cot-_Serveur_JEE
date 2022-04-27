package com.example.tp4.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @ToString
@AllArgsConstructor
public class Patient {
    /*@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nom;
    @NotEmpty
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
    private boolean malade;
<<<<<<< HEAD
=======
    @OneToMany(mappedBy = "patient", fetch=FetchType.LAZY)
    private Collection<Consultation> consultations;*/
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
    private boolean malade;
>>>>>>> 9af0b7ce26a107a2df6273224f96ea5c07265b17
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;

}
