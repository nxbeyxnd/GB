package ru.alexeisherkhonov.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexeisherkhonov.app.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
