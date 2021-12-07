package ru.alexeisherkhonov.app.models.dto;

import lombok.Data;

@Data
public class UserAuthDto {
    private String email;
    private String password;
}
