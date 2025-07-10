package com.ShambaSmart.input.controller;

import com.ShambaSmart.input.dto.FarmInputDTO;
import com.ShambaSmart.input.model.FarmInput;
import com.ShambaSmart.input.service.FarmInputService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Farm_inputs")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Farm Input Management", description = "APIs for managing farm inputs like seeds, fertilizers, etc.")
public class FarmInputController {

    private final FarmInputService inputService;

    @PostMapping
    @Operation(summary = "Add a new farm input")
    public ResponseEntity<FarmInput> createInput(@RequestBody FarmInputDTO input) {
        log.info("Creating new farm input: {}", input.getName());
        return ResponseEntity.ok(inputService.createInput(input));
    }

    @GetMapping
    @Operation(summary = "List all farm inputs")
    public ResponseEntity<List<FarmInputDTO>> getAllInputs() {
        log.info("Fetching all farm inputs");
        return ResponseEntity.ok(inputService.getAllInputs());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get farm input by ID")
    public ResponseEntity<FarmInput> getInputById(@PathVariable Long id) {
        log.info("Fetching input with ID: {}", id);
        return ResponseEntity.ok(inputService.getInputById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a farm input")
    public ResponseEntity<FarmInput> updateInput(@PathVariable Long id, @RequestBody FarmInputDTO updatedInput) {
        log.info("Updating farm input with ID: {}", id);
        return ResponseEntity.ok(inputService.updateInput(id, updatedInput));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a farm input")
    public ResponseEntity<Void> deleteInput(@PathVariable Long id) {
        log.info("Deleting farm input with ID: {}", id);
        inputService.deleteInput(id);
        return ResponseEntity.noContent().build();
    }
}

