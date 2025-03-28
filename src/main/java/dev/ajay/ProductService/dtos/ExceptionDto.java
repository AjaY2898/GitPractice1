package dev.ajay.ProductService.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;


public class ExceptionDto {
    private HttpStatus httpStatus;
    private String message ;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
