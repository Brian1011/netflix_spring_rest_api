package com.project.distributed.controller;

import com.project.distributed.models.Category;
import com.project.distributed.services.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "category")
public class CategoryController {
    private final CategoryService categoryService;

    private CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    // post
    @PostMapping
    Category createCategory(
            @Validated(Category.Create.class)
            @RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    // get
    @GetMapping
    public List<Category>findAll(){
        return categoryService.findAll();
    }

    // get a specific category
    @GetMapping(value = "{id}")
    Category findById(@PathVariable long id){
        return categoryService.findById(id);
    }

    // update
    @PatchMapping
    public Category updateCategory(
            @Validated(Category.Update.class)
            @RequestBody Category category)
    {
        return categoryService.update(category);
    }

}
