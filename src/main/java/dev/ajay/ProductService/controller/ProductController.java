package dev.ajay.ProductService.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/products/")
public class ProductController {

    @GetMapping("{id}")
    public void getProductById(@PathVariable("id") Long id ){

    }

    @GetMapping
    public  void getAllProduct(){

    }
    @DeleteMapping("{id}")
    public void deleteProductById(){

    }

    @PutMapping
    public void createProduct() {

    }
}
