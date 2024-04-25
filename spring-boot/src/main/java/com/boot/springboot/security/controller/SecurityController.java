package com.boot.springboot.security.controller;

import com.boot.springboot.security.model.dto.AuthRequestDto;
import com.boot.springboot.security.model.dto.AuthResponseDto;
import com.boot.springboot.security.model.dto.RegistrationUserDto;
import com.boot.springboot.security.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/security")
public class SecurityController {
    private UserSecurityService userSecurityService;

    @Autowired
    public SecurityController(UserSecurityService userSecurityService) {
        this.userSecurityService = userSecurityService;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody RegistrationUserDto registrationUserDto) {
        userSecurityService.registration(registrationUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/token")
    public ResponseEntity<AuthResponseDto> generateToken(@RequestBody AuthRequestDto authRequestDto) {
        Optional<String> token = userSecurityService.generateToken(authRequestDto);
        if (token.isPresent()) {
            return new ResponseEntity<>(new AuthResponseDto(token.get()), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
