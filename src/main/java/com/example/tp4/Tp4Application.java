package com.example.tp4;

import com.example.tp4.entities.Patient;
import com.example.tp4.repositories.PatientRepository;
import com.example.tp4.sec.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class Tp4Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp4Application.class, args);
    }

    //Utiliser Bcrypte comme type de cryptage
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Bean ca veux dire execute mois cette méthode 'run'
    //@Bean
    /*CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"AAAA", new Date(), false, 12));
            patientRepository.save(new Patient(null,"BBBB", new Date(), false, 10));
            patientRepository.save(new Patient(null,"CCCC", new Date(), false, 15));
            patientRepository.save(new Patient(null,"DDDD", new Date(), false, 17));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }*/

    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("ismail","1234","1234");
            securityService.saveNewUser("user1","1234","1234");
            securityService.saveNewUser("user2","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("ismail","ADMIN");
            securityService.addRoleToUser("ismail","USER");
            securityService.addRoleToUser("user1","USER");
            securityService.addRoleToUser("user2","USER");
        };
    }

}
