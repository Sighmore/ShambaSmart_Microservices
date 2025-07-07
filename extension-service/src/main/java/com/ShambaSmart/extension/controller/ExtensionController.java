package com.ShambaSmart.extension.controller;


import com.ShambaSmart.extension.dto.AgronomyAdviceDto;
import com.ShambaSmart.extension.model.*;
import com.ShambaSmart.extension.service.ExtensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/extension")
public class ExtensionController {

    private final ExtensionService extensionService;

    @Autowired
    public ExtensionController(ExtensionService extensionService) {
        this.extensionService = extensionService;
    }

    // 1️⃣ Get agronomy advice for a specific crop and region
    @GetMapping("/advisory")
    public ResponseEntity<AgronomyAdviceDto> getAgronomyAdvice(
            @RequestParam String crop,
            @RequestParam String region) {
        AgronomyAdviceDto advice = extensionService.getAgronomyAdvice(crop, region);
        return ResponseEntity.ok(advice);
    }

    // 2️⃣ Get farm monitoring alerts for a farm ID
    @GetMapping("/alerts/{farmId}")
    public ResponseEntity<List<FarmAlert>> getFarmAlerts(@PathVariable String farmId) {
        List<FarmAlert> alerts = extensionService.getFarmAlerts(farmId);
        return ResponseEntity.ok(alerts);
    }

    // 3️⃣ List training materials by topic
    @GetMapping("/training")
    public ResponseEntity<List<TrainingMaterial>> getTrainingMaterials(
            @RequestParam(required = false) String topic) {
        List<TrainingMaterial> materials = extensionService.getTrainingMaterials(topic);
        return ResponseEntity.ok(materials);
    }

    // 4️⃣ Get personalized recommendation for a farm
    @GetMapping("/recommendation/{farmId}")
    public ResponseEntity<Recommendations> getPersonalizedRecommendation(@PathVariable String farmId) {
        Recommendations recommendation = extensionService.getRecommendation(farmId);
        return ResponseEntity.ok(recommendation);
    }

    // 5️⃣ Submit farmer query (text-based query submission)
    @PostMapping("/query")
    public ResponseEntity<QueryResponse> submitFarmerQuery(@RequestBody FarmerQuery query) {
        QueryResponse response = extensionService.submitQuery(query);
        return ResponseEntity.ok(response);
    }
}
