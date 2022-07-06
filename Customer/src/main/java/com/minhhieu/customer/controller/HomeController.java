package com.minhhieu.customer.controller;

import com.minhhieu.library.dto.ProductDto;
import com.minhhieu.library.model.Category;
import com.minhhieu.library.model.Product;
import com.minhhieu.library.service.CategoryService;
import com.minhhieu.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String home(Model model){
        return "home";
    }

    @GetMapping("/home")
    public String index(Model model){
        List<Category> categories = categoryService.findAll();
        List<ProductDto> productDtos = productService.findAll();
        model.addAttribute("products", productDtos);
        model.addAttribute("categories", categories);
        return "index";
    }
}
