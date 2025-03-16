package dev.ajay.ProductService.service;

public interface ProductService {

    void getProductById(Long id);

    void getAllProducts();

    void deleteProductById();

    void createProduct();

    void updateProductById();
}