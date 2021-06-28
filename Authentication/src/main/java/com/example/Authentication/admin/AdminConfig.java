package com.example.Authentication.admin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AdminConfig {
    //creating a bean
    //------ TODO: ADD THE ADMIN OBJECT ATTRIBUTE TO THE DATABASE
    @Bean
    CommandLineRunner commandLineRunner(AdminRepository adminRepository) {
        return args -> {
            Admin test_admin = new Admin(
                    "Mariam69",
                    "ThisIsAPassword1097",
                    "mariam@gmail.com",
                    "Admin"
            );

            //save all the admin into a databse
            adminRepository.save(
                    test_admin
            );
        };
    }
}
