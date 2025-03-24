package dev.ajay.ProductService.controller;

import dev.ajay.ProductService.dtos.ExceptionDto;
import dev.ajay.ProductService.dtos.FakeStoreProductDto;
import dev.ajay.ProductService.dtos.GenericProductDto;
import dev.ajay.ProductService.exceptions.ProductNotFoundException;
import dev.ajay.ProductService.service.FakeStoreProductService;
import dev.ajay.ProductService.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {
    private static final Logger log = LogManager.getLogger(ProductController.class);


    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id ) throws ProductNotFoundException{
        return productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDto> getAllProduct(){
       return productService.getAllProducts();
    }

    @PostMapping
    public GenericProductDto createNewProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);

    }



    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){
        return productService.deleteProductById(id);
    }

    @PutMapping
    public void createProduct() {

    }
}
