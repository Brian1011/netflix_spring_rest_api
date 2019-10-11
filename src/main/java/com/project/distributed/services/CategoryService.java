package com.project.distributed.services;

import com.project.distributed.models.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    List<Category> findAll();

    Category update(Category category);

    Category findById(Long id);
}
