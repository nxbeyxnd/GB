package ru.alexeisherkhonov.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.alexeisherkhonov.app.models.dto.ProductDto;
import ru.alexeisherkhonov.app.models.entities.Product;
import ru.alexeisherkhonov.app.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

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
