package ru.alexeisherkhonov.app.models.dto;

import lombok.Data;
import ru.alexeisherkhonov.app.models.entities.Role;

@Data
public class RolePageDto {
    private Long id;
    private String name;

    public RolePageDto(Role role) {
        this.id = role.getId();
        this.name = role.getName();
    }
}
