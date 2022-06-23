package com.minhhieu.library.service;

import com.minhhieu.library.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
    Category findById(Long id);
    Category getById(Long id);
    Category update(Category category);
    void deleteById(Long id);
    void enabledById(Long id);
}
