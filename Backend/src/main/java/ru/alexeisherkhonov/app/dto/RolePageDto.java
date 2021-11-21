package ru.alexeisherkhonov.app.dto;

import lombok.Data;
import ru.alexeisherkhonov.app.entities.Role;

@Data
public class RolePageDto {
    private Long id;
    private String name;

    public RolePageDto(Role role) {
        this.id = role.getId();
        this.name = role.getName();
    }
}
