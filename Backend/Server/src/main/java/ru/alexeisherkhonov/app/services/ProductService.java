package ru.alexeisherkhonov.app.services;

import org.springframework.stereotype.Service;
import ru.alexeisherkhonov.app.models.dto.ProductDto;
import ru.alexeisherkhonov.app.models.entities.Product;
import ru.alexeisherkhonov.app.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<ProductDto> findById(Long id){
        return productRepository.findById(id).map(ProductDto::new);
    }

    public void saveOrUpdate(Product product){
        productRepository.save(product);
    }

    public List<ProductDto> showAllProducts(){
        return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

}
