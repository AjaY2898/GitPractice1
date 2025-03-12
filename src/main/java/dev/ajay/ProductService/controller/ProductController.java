package dev.ajay.ProductService.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/product/")
public class ProductController {

    @GetMapping("{id}")
    public void getProductById(@PathVariable("id") Long id ){

    }

    @DeleteMapping("{id}")
    public void deleteProductById(){

    }
    @GetMapping
    public  void getAllProduct(){

    }
    @PutMapping
    public void createProduct(){

    }
}
