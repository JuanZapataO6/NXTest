package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
