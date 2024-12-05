package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private Long id;
    private String Name;
    private Double Price;
    private Double Quantity;
    private MultipartFile ImageURL;

    public ProductForm() {
    }

    public ProductForm(Long id, String name, Double price, Double quantity, MultipartFile imageURL) {
        this.id = id;
        Name = name;
        Price = price;
        Quantity = quantity;
        ImageURL = imageURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getQuantity() {
        return Quantity;
    }

    public void setQuantity(Double quantity) {
        Quantity = quantity;
    }

    public MultipartFile getImageURL() {
        return ImageURL;
    }

    public void setImageURL(MultipartFile imageURL) {
        ImageURL = imageURL;
    }
}

