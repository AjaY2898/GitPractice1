package dev.ajay.ProductService.exceptions;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String msg){
        super(msg);
    }
}
