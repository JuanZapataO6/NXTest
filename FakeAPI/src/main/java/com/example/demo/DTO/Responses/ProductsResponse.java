package com.example.demo.DTO.Responses;

import jakarta.jws.Oneway;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
public class ProductsResponse {
    HttpStatus httpStatus;
    String body;
}
