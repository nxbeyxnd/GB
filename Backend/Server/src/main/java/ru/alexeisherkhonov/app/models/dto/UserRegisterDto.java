package ru.alexeisherkhonov.app.models.dto;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String email;
    private String password;
}
