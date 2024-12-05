package com.codegym.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private Double Price;
    private Double Quantity;
    private String ImageURL;

    public Product() {
    }

    public Product(Long id, String name, Double price, Double quantity, String fileName) {
        this.id = id;
        Name = name;
        Price = price;
        Quantity = quantity;
        ImageURL = fileName;
    }
}
