package main.controller;

import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiAuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/auth/check")
    private ResponseEntity getAuthCheck(){
        return ResponseEntity.ok(userService.getAuthCheck());
    }
}
