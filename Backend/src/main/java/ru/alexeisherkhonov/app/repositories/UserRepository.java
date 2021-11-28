package ru.alexeisherkhonov.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexeisherkhonov.app.models.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findUserByEmailAndPassword(String email, String password);
}
