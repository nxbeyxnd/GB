package ru.alexeisherkhonov.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexeisherkhonov.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
