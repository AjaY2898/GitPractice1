package dev.ajay.ProductService.controller;

import dev.ajay.ProductService.dtos.ExceptionDto;
import dev.ajay.ProductService.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ExceptionDto handleProductNotFounException(ProductNotFoundException productNotFoundException){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        return exceptionDto;
//        return new ResponseEntity<>(
//                exceptionDto,
//                HttpStatus.NOT_FOUND
//        );
    }
}
