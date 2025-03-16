package dev.ajay.ProductService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2.0/")
public class HealthController {

    @GetMapping("health")
    public String checkHealth(){
        return "Application is up and running : ";
    }
}
