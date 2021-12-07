package ru.alexeisherkhonov.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.alexeisherkhonov.app.models.dto.ProductDto;
import ru.alexeisherkhonov.app.models.entities.Product;
import ru.alexeisherkhonov.app.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductDto> showAllProducts(){
        return productService.showAllProducts();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public void addNewProduct(@RequestBody Product product){
        product.setId(null);
        productService.saveOrUpdate(product);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping()
    public void updateProduct(@RequestBody Product product){
        productService.saveOrUpdate(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
    }
}
