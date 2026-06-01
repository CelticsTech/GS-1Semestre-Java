package com.globalsolution.java.celticstech.controller;

import com.globalsolution.java.celticstech.dto.request.LoginRequestDTO;
import com.globalsolution.java.celticstech.dto.response.LoginResponseDTO;
import com.globalsolution.java.celticstech.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO loginRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.login(loginRequest));
    }
}