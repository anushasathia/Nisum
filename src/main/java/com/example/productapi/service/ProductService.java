package com.example.productapi.service;

import com.example.productapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public List<Product> getAll() {
        return products;
    }

    public Product getById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean updateProduct(int id, Product updated) {
        Optional<Product> existing = products.stream().filter(p -> p.getId() == id).findFirst();
        if (existing.isPresent()) {
            products.remove(existing.get());
            updated.setId(id);
            products.add(updated);
            return true;
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        return products.removeIf(p -> p.getId() == id);
    }
}
