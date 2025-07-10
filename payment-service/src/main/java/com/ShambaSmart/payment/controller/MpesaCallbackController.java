package com.ShambaSmart.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/mpesa")
public class MpesaCallbackController {

    @PostMapping("/callback")
    public ResponseEntity<String> handleMpesaCallback(@RequestBody Map<String, Object> payload) {
        // You can map it to a POJO for cleaner structure
        System.out.println("M-Pesa Callback: " + payload);

        // TODO: Extract info, verify, save to DB, etc.

        return ResponseEntity.ok("Received");
    }
}
