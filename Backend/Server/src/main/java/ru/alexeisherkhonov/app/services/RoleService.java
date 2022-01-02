package ru.alexeisherkhonov.app.services;

import org.springframework.stereotype.Service;
import ru.alexeisherkhonov.app.models.entities.Role;
import ru.alexeisherkhonov.app.repositories.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleByName(String name){
        return roleRepository.findRoleByName(name);
    }
}
