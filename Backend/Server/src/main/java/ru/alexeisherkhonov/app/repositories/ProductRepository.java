package ru.alexeisherkhonov.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexeisherkhonov.app.models.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
