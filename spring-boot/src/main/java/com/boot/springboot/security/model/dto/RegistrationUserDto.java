package com.boot.springboot.security.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RegistrationUserDto {
    private String login;
    private String password;
    private String username;
    private Integer age;
}
