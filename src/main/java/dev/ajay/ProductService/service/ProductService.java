package dev.ajay.ProductService.service;

import dev.ajay.ProductService.dtos.FakeStoreProductDto;
import dev.ajay.ProductService.dtos.GenericProductDto;
import dev.ajay.ProductService.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    public GenericProductDto getProductById(Long id) throws ProductNotFoundException;

    public List<GenericProductDto> getAllProducts();

    public GenericProductDto deleteProductById(Long id);

    public GenericProductDto createProduct(GenericProductDto genericProductDto);

    void updateProductById();
}