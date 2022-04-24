package com.example.tp4;

import com.example.tp4.entities.Patient;
import com.example.tp4.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Tp4Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp4Application.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"AAAA", new Date(), false, 12));
            patientRepository.save(new Patient(null,"BBBB", new Date(), false, 10));
            patientRepository.save(new Patient(null,"CCCC", new Date(), false, 15));
            patientRepository.save(new Patient(null,"DDDD", new Date(), false, 17));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }

}
