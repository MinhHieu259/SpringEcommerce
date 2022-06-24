package com.minhhieu.library.service.impl;

import com.minhhieu.library.dto.ProductDto;
import com.minhhieu.library.model.Product;
import com.minhhieu.library.repository.ProductRepository;
import com.minhhieu.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtoList = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for (Product product : products){
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setDescription(product.getDescription());
            productDto.setCostPrice(product.getCostPrice());
            productDto.setSalePrice(product.getSalePrice());
            productDto.setCurrentQuantity(product.getCurrentQuantity());
            productDto.setCategory(product.getCategory());
            productDto.setImage(product.getImage());
            productDto.setActivated(product.is_activated());
            productDto.setDeleted(product.is_deleted());
            productDtoList.add(productDto);
        }

        return productDtoList;
    }

    @Override
    public Product save(ProductDto product) {
        return null;
    }

    @Override
    public Product update(ProductDto product) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void enableById(Long id) {

    }
}
