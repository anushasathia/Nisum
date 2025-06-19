package com.example.productapi.controller;

import com.example.productapi.model.Product;
import com.example.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return service.getAll();
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = service.getById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        service.addProduct(product);
        return ResponseEntity.ok("Product added successfully");
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
        boolean updated = service.updateProduct(id, product);
        return updated ? ResponseEntity.ok("Product updated") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        boolean deleted = service.deleteProduct(id);
        return deleted ? ResponseEntity.ok("Product deleted") : ResponseEntity.notFound().build();
    }
}
