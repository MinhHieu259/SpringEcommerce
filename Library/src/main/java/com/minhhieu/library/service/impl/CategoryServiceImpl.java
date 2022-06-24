package com.minhhieu.library.service.impl;

import com.minhhieu.library.model.Category;
import com.minhhieu.library.repository.CategoryRepository;
import com.minhhieu.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repo;
    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public Category save(Category category) {
        try {
            Category categorySave = new Category(category.getName());
            return repo.save(categorySave);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Category findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Category getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Category update(Category category) {
        Category categoryUpdate = null;
       try {
           categoryUpdate = repo.findById(category.getId()).get();
           categoryUpdate.setName(category.getName());
           categoryUpdate.set_activeted(true);
           categoryUpdate.set_deleted(category.is_deleted());
       }catch (Exception e){
           e.printStackTrace();
       }
        return repo.save(categoryUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Category category = repo.getById(id);
        category.set_deleted(true);
        category.set_activeted(false);
        repo.save(category);
    }

    @Override
    public void enabledById(Long id) {
        Category category = repo.getById(id);
        category.set_activeted(true);
        category.set_deleted(false);
        repo.save(category);
    }

    @Override
    public List<Category> findAllByActivated() {
        return repo.findAllByActivated();
    }
}
