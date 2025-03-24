package dev.ajay.ProductService.thirdPartyClients.fakeStoreClient;

import dev.ajay.ProductService.dtos.FakeStoreProductDto;
import dev.ajay.ProductService.dtos.GenericProductDto;
import dev.ajay.ProductService.exceptions.ProductNotFoundException;
import dev.ajay.ProductService.thirdPartyClients.ThirdPartyInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreClientAdaptor  {
    private static final Logger log = LogManager.getLogger(FakeStoreClientAdaptor.class);

    private RestTemplateBuilder restTemplateBuilder;

    @Value("${get.all.product.url}")
    private String getProductUrl;

    public FakeStoreClientAdaptor(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }


    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
//
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.getForEntity(getProductUrl +id, FakeStoreProductDto.class);

        if(response.getBody() == null){
            log.error("Product does not exists for given ID: from logger" + id );
            throw new ProductNotFoundException("Product does not exists for given ID:" +id);
        }
        return response.getBody();

//        return f;
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
//
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(getProductUrl, FakeStoreProductDto[].class);


        return Arrays.asList(response.getBody());
    }


    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto>  response =  ((ResponseEntity)restTemplate.execute(getProductUrl, HttpMethod.GET, requestCallback, responseExtractor,id));
        return response.getBody();
    }


    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> createdProduct =
                restTemplate.postForEntity(getProductUrl,genericProductDto,FakeStoreProductDto.class);

        return createdProduct.getBody();
    }


    public void updateProductById() {

    }
}
