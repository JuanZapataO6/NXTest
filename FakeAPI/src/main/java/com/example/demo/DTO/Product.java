package com.example.demo.DTO;

import lombok.Data;

@Data
public class Product {
    String title;
    int price;
    String description;
    int categoryId;
    String images[];

}
