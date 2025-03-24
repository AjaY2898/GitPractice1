package dev.ajay.ProductService.service;

import dev.ajay.ProductService.dtos.FakeStoreProductDto;
import dev.ajay.ProductService.dtos.GenericProductDto;
import dev.ajay.ProductService.exceptions.ProductNotFoundException;

import dev.ajay.ProductService.thirdPartyClients.fakeStoreClient.FakeStoreClientAdaptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private static final Logger log = LogManager.getLogger(FakeStoreProductService.class);

    private FakeStoreClientAdaptor fakeStoreClientAdaptor;

    private FakeStoreProductService(FakeStoreClientAdaptor fakeStoreClientAdaptor){
        this.fakeStoreClientAdaptor = fakeStoreClientAdaptor;
    }

    private RestTemplateBuilder restTemplateBuilder;

    @Value("${get.all.product.url}")
    private String getProductUrl;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
       return convertGenricProductDto(fakeStoreClientAdaptor.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClientAdaptor.getAllProducts();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            genericProductDtos.add(convertGenricProductDto(fakeStoreProductDto));
        }

        return  genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return convertGenricProductDto(fakeStoreClientAdaptor.deleteProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertGenricProductDto(fakeStoreClientAdaptor.createProduct(genericProductDto));
    }

    @Override
    public void updateProductById() {

    }

    private static GenericProductDto convertGenricProductDto(FakeStoreProductDto fakeStoreProductDto){

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());

        return genericProductDto;
    }
}
