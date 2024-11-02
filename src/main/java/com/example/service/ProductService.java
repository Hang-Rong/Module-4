package com.example.service;

import com.example.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Candy", 1.00, 50));
        products.put(2, new Product(2, "Milk-Chocolate", 15.00, 150));
        products.put(3, new Product(3, "Mochi", 3.00, 250));
        products.put(4, new Product(4, "Biscuit", 2.00, 70));
        products.put(5, new Product(5, "Potato Chip", 6.00, 120));
        products.put(6, new Product(6, "Canned Fruit", 10.00, 100));
        products.put(7, new Product(7, "Pop-corn", 8.10, 60));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }
}
