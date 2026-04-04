package com.example.product_management.service;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> productList = new ArrayList<>();

    // Constructor tạo 3 đối tượng mới
    public ProductService() {
        productList.add(new Product(1,"Iphone15",999));
        productList.add(new Product(2,"Iphone16",1999));
        productList.add(new Product(3,"Iphone17",2999));
    }

    //Nghiệp vụ lấy tất cả danh sách sản phẩm
    public List<Product> getProductList() {
        return productList;
    }

    // nghiệp vụ thêm mới sản phẩm
    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    // nghiệp vụ cập nhật thông tin sản phẩm
    public Product updateProduct(int id,Product product) {
        for (Product p : productList) {
            if (p.getId() == id) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                return p;
            }
        }
        return null;
    }

    // nghiệp vụ xóa sản phẩm
    public boolean deleteProduct(int id) {
        boolean result = false;
        for (Product p : productList) {
            if (p.getId() == id) {
                productList.remove(p);
                result = true;
            }
        }
        if (result) {
            System.out.println("Xóa thành công");
        }else
            System.out.println("K xóa được");
        return result;
    }
}
