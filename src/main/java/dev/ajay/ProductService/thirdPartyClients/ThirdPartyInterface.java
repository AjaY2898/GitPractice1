package dev.ajay.ProductService.thirdPartyClients;

import dev.ajay.ProductService.dtos.GenericProductDto;
import dev.ajay.ProductService.exceptions.ProductNotFoundException;

import java.util.List;

public interface ThirdPartyInterface {


    public GenericProductDto getProductById(Long id) throws ProductNotFoundException;

    public List<GenericProductDto> getAllProducts();

    public GenericProductDto deleteProductById(Long id);

    public GenericProductDto createProduct(GenericProductDto genericProductDto);

    void updateProductById();
}
