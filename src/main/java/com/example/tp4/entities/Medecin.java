package com.example.tp4.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medecin {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idM;
    @NotEmpty
    @Size(min = 4, max = 40)
    private String nom;
    @OneToMany(mappedBy = "medecin", fetch=FetchType.LAZY)
    private Collection<Consultation> consultations;*/

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 4, max = 40)
    private String nom;
    private String email;
    private String specialite;
    @OneToMany(mappedBy="medecin", fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
