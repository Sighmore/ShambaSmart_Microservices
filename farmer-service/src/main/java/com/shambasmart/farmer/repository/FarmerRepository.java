package com.shambasmart.farmer.repository;

import com.shambasmart.farmer.model.Farmer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {


    boolean existsByEmail(@Email(message = "Email should be valid") @NotBlank(message = "Email is required") String email);

    Farmer findByEmail(@Email(message = "Email should be valid") @NotBlank(message = "Email is required") String email);


    User findByUsername(String username);
}
