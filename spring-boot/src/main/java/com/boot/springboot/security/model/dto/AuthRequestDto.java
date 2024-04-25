package com.boot.springboot.security.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AuthRequestDto {
    private String login;
    private String password;
}
