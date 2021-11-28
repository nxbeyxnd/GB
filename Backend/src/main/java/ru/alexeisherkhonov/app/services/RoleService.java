package ru.alexeisherkhonov.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexeisherkhonov.app.models.entities.Role;
import ru.alexeisherkhonov.app.repositories.RoleRepository;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role findRoleByName(String name){
        return roleRepository.findRoleByName(name);
    }
}
