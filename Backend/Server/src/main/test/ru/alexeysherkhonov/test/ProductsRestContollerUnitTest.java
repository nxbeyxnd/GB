package ru.alexeysherkhonov.test;
/* 
02.01.2022: Alexey created this file inside the package: ru.alexeysherkhonov.test 
*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.alexeisherkhonov.app.controllers.ProductController;
import ru.alexeisherkhonov.app.models.dto.ProductDto;
import ru.alexeisherkhonov.app.models.entities.Product;
import ru.alexeisherkhonov.app.services.ProductService;

import java.time.LocalDateTime;
import java.util.List;

public class ProductsRestContollerUnitTest {

    ProductService productService = Mockito.mock(ProductService.class);
    ProductController productController;
    List<ProductDto> mockProductList;

    @BeforeEach
    public void setUp() {
        mockProductList = List.of(
                new ProductDto(new Product(1L, "test1", 100, LocalDateTime.now(), LocalDateTime.now())),
                new ProductDto(new Product(2L, "test2", 100, LocalDateTime.now(), LocalDateTime.now())),
                new ProductDto(new Product(3L, "test3", 100, LocalDateTime.now(), LocalDateTime.now())),
                new ProductDto(new Product(4L, "test3", 100, LocalDateTime.now(), LocalDateTime.now()))
        );
    }

    @Test
    void testGetAllProducts() {
        productController = new ProductController(productService);
        List<ProductDto> mockDtoList = mockProductList;
        Mockito.when(productService.showAllProducts()).thenReturn(mockProductList);
        List<ProductDto> allProductsEntity = productController.showAllProducts();

        Assertions.assertEquals(allProductsEntity.size(), mockDtoList.size());
    }
}
