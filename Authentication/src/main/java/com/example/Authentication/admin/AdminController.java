package com.example.Authentication.admin;

//Contains all resources for our API

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// full path = localhost:8080/api/v1/admin
@RequestMapping(path="api/v1/admin")
public class AdminController {

    private final AdminService adminService;
    @Autowired
    //constructor for admin service:
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping
    public List<Admin> getAdmin(){
        return adminService.getAdmin();
    }

    //API that will take a user payload and write it into the database
    @PostMapping
    public void registerAdmin(@RequestBody Admin admin){
        adminService.addAdmin(admin);
    }

    //API to delete a user based on the id
    @DeleteMapping(path="{adminID}")
    public void deleteAdmin(@PathVariable("adminID") Long id){
        adminService.deleteAdmin(id);
    }
}
