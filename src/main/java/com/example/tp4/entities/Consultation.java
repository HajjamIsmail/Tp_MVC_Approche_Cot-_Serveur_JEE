package com.example.tp4.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Consultation {
<<<<<<< HEAD
=======
    /*@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_Cons;
    @DecimalMin("70")
    private float prix_Cons;
    @ManyToOne
    @JoinColumn(name = "id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "idM")
    private Medecin medecin;*/
>>>>>>> 9af0b7ce26a107a2df6273224f96ea5c07265b17
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateConsultation;
    @DecimalMin("70")
    private float prix_Cons;
    private String rapport;
    @OneToOne
    private RendezVous rendezVous;
}
