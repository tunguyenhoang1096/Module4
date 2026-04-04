package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // Lấy danh sách
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProductList();
    }

    // Thêm mới
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Cập nhật theo id
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // Xóa theo id
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
