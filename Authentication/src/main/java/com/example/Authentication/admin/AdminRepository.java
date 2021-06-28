package com.example.Authentication.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//--- Contains code for accessing the databse ------
@Repository
//takes in an admin object and an ID to identify what we are looking at
public interface AdminRepository extends JpaRepository<Admin, Long>{
    //Custom api logic, find a user by emails
    //SELECT * FROM admin where email = ?
    @Query("SELECT s FROM Admin s WHERE s.email = ?1")
    Optional<Admin> findAdminByEmail(String email);

}
