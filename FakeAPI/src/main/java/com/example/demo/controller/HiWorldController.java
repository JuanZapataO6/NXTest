package com.example.demo.controller;

import com.example.demo.DTO.Entities.Product;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("nexsys/v1")
public class HiWorldController {
    RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/sayhi")
    public String sayHi(){
        return "Hello Juan Pablo ";
    }
    @GetMapping("/products")
    public String getAllProducts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                "https://api.escuelajs.co/api/v1/products",
                HttpMethod.GET, entity, String.class).getBody();
    }
    @GetMapping("/categories")
    public String getAllCategories() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                "https://api.escuelajs.co/api/v1/categories",
                HttpMethod.GET, entity, String.class).getBody();
    }
    @PostMapping("/products")
    public String createProduct (@RequestBody Product product) {
        System.out.println(product);
        ResponseEntity<String> response =
                restTemplate.postForEntity("https://api.escuelajs.co/api/v1/products", product, String.class);
        System.out.println(response.getBody());
        return response.getBody();
    }
}
