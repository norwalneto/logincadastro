package com.projetos.logincadastro.controller;

import com.projetos.logincadastro.model.User;
import com.projetos.logincadastro.model.UserCredentials;
import com.projetos.logincadastro.service.AuthService;
import com.projetos.logincadastro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserCredentials credentials){
        boolean isAuthenticated = authService.authenticate(credentials.getEmail(), credentials.getPassword());
        Map<String, Object> response = new HashMap<>();

        if (isAuthenticated) {
            response.put("success", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

    }

    // Endpoint de Cadastro
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody UserCredentials credentials) {
        boolean isRegistered = userService.register(credentials.getEmail(), credentials.getPassword());
        Map<String, Object> response = new HashMap<>();

        if (isRegistered) {
            response.put("success", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
