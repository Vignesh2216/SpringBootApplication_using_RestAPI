package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/get")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // @GetMapping("/product/get/{id}")
    // public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        //     return productService.getProductById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        // }

        @PostMapping("/product/add")
        public Product createProduct(@RequestBody Product product) {
            return productService.createProduct(product);
        }

        @PutMapping("/product/put/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
            return ResponseEntity.ok(productService.updateProduct(id, productDetails));
        }

        @DeleteMapping("/product/del/{id}")
        public String deleteProduct(@PathVariable Long id) {
            productService.deleteProduct(id);
            return "Product deleted successfully";
        }
    }