package com.minhhieu.library.service;

import com.minhhieu.library.dto.ProductDto;
import com.minhhieu.library.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    Product save(ProductDto product);
    Product update(ProductDto product);
    void deleteById(Long id);
    void enableById(Long id);
}
