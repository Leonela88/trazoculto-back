package com.trazoculto.editorial.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.trazoculto.editorial.entity.Administrator;
import com.trazoculto.editorial.repository.AdministratorRepository;

@Component
public class AdminSeeder implements CommandLineRunner{

    @Value("${ADMIN_EMAIL}")
    private String adminEmail;

    @Value("${ADMIN_PASSWORD}")
    private String adminPassword;

    @Autowired
    private AdministratorRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run (String... args) throws Exception{


        if (repository.count() == 0) {
            Administrator admin = new Administrator();
            admin.setEmail(adminEmail); 
            admin.setPassword(passwordEncoder.encode(adminPassword)); 
            repository.save(admin);
            System.out.println("=> User admin created by default.");
        }

        
        

    }

}
