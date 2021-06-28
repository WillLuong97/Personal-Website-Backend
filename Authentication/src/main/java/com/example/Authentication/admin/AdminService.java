package com.example.Authentication.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// --- Contains Util Service Functions to handle API Business Logic -------
@Service
public class AdminService {
    //referencing the JPA repository from the interface
    private final AdminRepository adminRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    public List<Admin> getAdmin(){
        return adminRepository.findAll();
    }
    public void addAdmin(Admin admin){
        //Find an admin via email
        Optional<Admin> adminByEmail = adminRepository.findAdminByEmail(admin.getEmail());
        //if the email already exist, then we will return exception
        if(adminByEmail.isPresent()){
            throw new IllegalStateException("Email Taken!");
        }
        //if the user is not already in the database, then we will add it into our database
        adminRepository.save(admin);
    }

    public void deleteAdmin(Long adminId){
        //boolean to check if the id is in the databse or not
        boolean exist = adminRepository.existsById(adminId);
        if(!exist){
            throw new IllegalStateException("Admin with id " + adminId + " does not exist");
        }
        //delete the user by 1:
        adminRepository.deleteById(adminId);
    }
}
