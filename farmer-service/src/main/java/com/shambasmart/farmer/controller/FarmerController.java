package com.shambasmart.farmer.controller;

import com.shambasmart.farmer.dto.farmerDto;
import com.shambasmart.farmer.model.ApiResponse;
import com.shambasmart.farmer.model.Farmer;
import com.shambasmart.farmer.service.FarmerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmers")
@Slf4j
@Tag(name = "Farmer Management", description = "APIs for managing farmers")
@RequiredArgsConstructor
@Validated
public class FarmerController {

    private final FarmerService farmerService;

    @Operation(summary = "Fetch a farmer by ID", description = "Retrieves a farmer by their ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Farmer>> getFarmerById(@PathVariable Long id) {
        log.info("Fetching farmer with ID: {}", id);
        Farmer farmer = farmerService.getFarmerById(id);
        return ResponseEntity.ok(new ApiResponse<>("Farmer retrieved successfully", farmer, true));
    }

    @Operation(summary = "Fetch all farmers", description = "Retrieves a list of all farmers")
    @GetMapping
    public ResponseEntity<ApiResponse<List<farmerDto>>> getAllFarmers() {
        List<farmerDto> farmers = farmerService.getAllFarmers();
        log.info("Fetching all farmers, total count: {}", farmers.size());
        return ResponseEntity.ok(new ApiResponse<>("List of all farmers", farmers, true));
    }

    @Operation(summary = "Create a new farmer", description = "Creates a new farmer and returns the created farmer object")
    @PostMapping
    public ResponseEntity<ApiResponse<Farmer>> createFarmer(@Valid @RequestBody farmerDto farmerDto) {
        Farmer farmer = farmerService.CreateFarmer(farmerDto);
        log.info("Farmer created with Email: {}", farmer.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Farmer created successfully", farmer, true));
    }

    @Operation(summary = "Update an existing farmer", description = "Updates the details of an existing farmer and returns the updated farmer object")
    @PutMapping
    public ResponseEntity<ApiResponse<Farmer>> updateFarmer(@Valid @RequestBody farmerDto farmerDto) {
        Farmer updatedFarmer = farmerService.updateFarmer(farmerDto);
        log.info("Farmer updated with Email: {}", updatedFarmer.getEmail());
        return ResponseEntity.ok(new ApiResponse<>("Farmer updated successfully", updatedFarmer, true));
    }

    @Operation(summary = "Delete a farmer", description = "Deletes a farmer by ID and returns a success message")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteFarmer(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
        log.info("Farmer deleted with ID: {}", id);
        return ResponseEntity.ok(new ApiResponse<>("Farmer deleted successfully", "Deleted farmer with ID: " + id, true));
    }
}
