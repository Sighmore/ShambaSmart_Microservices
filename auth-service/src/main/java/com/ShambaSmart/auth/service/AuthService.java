package com.ShambaSmart.auth.service;


import com.ShambaSmart.auth.config.JwtUtils;
import com.ShambaSmart.auth.dto.AuthRequest;
import com.ShambaSmart.auth.dto.AuthResponse;
import com.ShambaSmart.auth.dto.MessageResponse;
import com.ShambaSmart.auth.dto.RegisterRequest;
import com.ShambaSmart.auth.entity.User;
import com.ShambaSmart.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public MessageResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return new MessageResponse("Error: Username is already taken!");
        }

        User user = User.builder()
                .Username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(request.getRoles() == null || request.getRoles().isEmpty()
                        ? Set.of("ROLE_USER")
                        : request.getRoles())
                .build();

        userRepository.save(user);

        return new MessageResponse("User registered successfully!");
    }

    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Error: User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Error: Invalid credentials");
        }

        String token = jwtUtils.generateToken(user);
        String refreshToken = jwtUtils.generateRefreshToken(user);

        return AuthResponse.builder()
                .token(token)
                .refreshToken(refreshToken)
                .tokenType("Bearer")
                .build();
    }

    public AuthResponse refreshToken(String refreshToken) {
        if (!jwtUtils.validateToken(refreshToken)) {
            throw new RuntimeException("Error: Invalid refresh token");
        }

        String username = jwtUtils.getUsernameFromToken(refreshToken);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Error: User not found"));

        String newToken = jwtUtils.generateToken(user);

        return AuthResponse.builder()
                .token(newToken)
                .refreshToken(refreshToken) // same refresh token or generate a new one if you prefer
                .tokenType("Bearer")
                .build();
    }
}
