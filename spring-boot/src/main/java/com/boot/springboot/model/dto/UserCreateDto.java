package com.boot.springboot.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserCreateDto {
    @NotNull
    @Size(min = 6, max = 15)
    private String username;

    @NotNull
    @Size(min = 6, max = 15)
    private String userPassword;

    @NotNull
    private Integer age;
}
