package com.minhhieu.customer.controller;

import com.minhhieu.library.model.Product;
import com.minhhieu.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public String products(Model model){
        List<Product> products = productService.getAllProducts();
        List<Product> listViewProduts = productService.listViewProduct();
        model.addAttribute("products", products);
        model.addAttribute("viewProducts", listViewProduts);
        return "shop";
    }
}
