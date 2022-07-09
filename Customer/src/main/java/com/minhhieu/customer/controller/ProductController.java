package com.minhhieu.customer.controller;

import com.minhhieu.library.dto.CategoryDto;
import com.minhhieu.library.model.Category;
import com.minhhieu.library.model.Product;
import com.minhhieu.library.service.CategoryService;
import com.minhhieu.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/products")
    public String products(Model model){
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndProduct();
        List<Product> products = productService.getAllProducts();
        List<Product> listViewProduts = productService.listViewProduct();
        model.addAttribute("categories", categoryDtoList);
        model.addAttribute("products", products);
        model.addAttribute("viewProducts", listViewProduts);
        return "shop";
    }

    @GetMapping("/find-product/{id}")
    public String findProductById(@PathVariable("id") Long id, Model model){
        Product product = productService.getProductById(id);
        Long categoryId = product.getCategory().getId();
        List<Product> products = productService.getRelatedProduct(categoryId);
        model.addAttribute("product", product);
        model.addAttribute("products", products);
        return "product-detail";
    }

    @GetMapping("/products-in-category/{id}")
    public String getProductsInCategory(@PathVariable("id") Long categoryId, Model model){
        List<CategoryDto> categories = categoryService.getCategoryAndProduct();
        Category category = categoryService.findById(categoryId);
        List<Product> products = productService.getProductsInCategory(categoryId);
        model.addAttribute("categories", categories);
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        return "products-in-category";
    }

    @GetMapping("/high-price")
    public String filterHighPrice(Model model){
        List<Category> categories = categoryService.findAllByActivated();
        List<Product> products = productService.filterHighPrice();
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndProduct();
        model.addAttribute("categoryDtoList", categoryDtoList);
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "filter-high-price";
    }
}
