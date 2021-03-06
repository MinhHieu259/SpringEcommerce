package com.minhhieu.library.service;

import com.minhhieu.library.dto.ProductDto;
import com.minhhieu.library.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    /*Admin*/
    List<ProductDto> findAll();
    Product save(MultipartFile imageProduct, ProductDto product);
    Product update(MultipartFile imageProduct, ProductDto product);
    void deleteById(Long id);
    void enableById(Long id);
    ProductDto getById(Long id);
    Page<ProductDto> pageProducts(int pageNo);
    Page<ProductDto> searchProducts(int pageNo, String keyword);

    /*Customer*/
    List<Product> getAllProducts();

    List<Product> listViewProduct();
    Product getProductById(Long id);

    List<Product> getRelatedProduct(Long categoryId);
    List<Product> getProductsInCategory(Long categoryId);
    List<Product> filterHighPrice();
    List<Product> filterLowPrice();
}
