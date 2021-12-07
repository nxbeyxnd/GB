package ru.alexeisherkhonov.app.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.alexeisherkhonov.app.models.dto.ProductDto;
import ru.alexeisherkhonov.app.services.ProductService;

import java.util.Optional;

@Endpoint
public class ProductEndpoint {
    private static final String NAMESPACE_URL = "http://alexeisherkhonov.ru/app/endpoints";

    @Autowired
    ProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProductRequest(@RequestPayload GetProductRequest request){
        GetProductResponse response = new GetProductResponse();
        ProductResponse productResponse = new ProductResponse();
        response.setProduct(createProductResponse(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getProductsRequest(@RequestPayload GetProductsRequest request){
        GetProductsResponse response = new GetProductsResponse();
        return createProductsResponse(response);
    }

    private GetProductsResponse createProductsResponse(GetProductsResponse response){
        for(ProductDto p : productService.showAllProducts()){
            ProductResponse pr = new ProductResponse();
            pr.setId(p.getId());
            pr.setTitle(p.getTitle());
            pr.setCost(p.getCost());
            response.getProducts().add(pr);
        }
        return response;
    }

    private ProductResponse createProductResponse(Long id){
        ProductResponse productResponse = new ProductResponse();
        Optional<ProductDto> product= productService.findById(id);
        productResponse.setId(product.get().getId());
        productResponse.setTitle(product.get().getTitle());
        productResponse.setCost(product.get().getCost());
        return productResponse;
    }

}
