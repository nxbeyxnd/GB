package ru.alexeisherkhonov.app.dto;

import lombok.Data;
import ru.alexeisherkhonov.app.entities.Role;
import ru.alexeisherkhonov.app.entities.User;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserPageDto {
    private Long id;
    private String email;
    private String firstname;
    private String secondname;
    private List<RolePageDto> rolePageDtoList;

    public UserPageDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstname = user.getFirstname();
        this.secondname = user.getSecondname();
        List<RolePageDto> roles = new ArrayList<>();
        for (Role r : user.getRoles()){
            roles.add(new RolePageDto(r));
        }
        this.rolePageDtoList = roles;
    }
}
