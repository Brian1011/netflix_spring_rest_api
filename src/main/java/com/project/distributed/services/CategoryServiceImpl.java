package com.project.distributed.services;

import com.project.distributed.NotFoundException;
import com.project.distributed.models.Category;
import com.project.distributed.models.Movie;
import com.project.distributed.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Category category) {
        // look for the object first
        Category found = findById(category.getId());

        // update the object
        found.setCategoryName(category.getCategoryName());
        return categoryRepository.save(found);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()
        ->new NotFoundException("No category with the id" + id));
    }

    @Override
    public Category findAvailableMovie(long id, String type) {
        //look for the object first
        //Category home = findById(id);

        String response = "Id: "+id+" \n Type: "+type;
        System.out.println(response);
        if(type.equals("original")){
            System.out.println("original");
            return categoryRepository.findCatBySuggested(id,type);
        }else if(type.equals("suggested")){
            System.out.println("suggested");
            return categoryRepository.findCatBySuggested(id,type);
        }else {
            System.out.println("others");
            return categoryRepository.findCatBySuggested(id,type);
            //return categoryRepository.fi(id, type);
        }
    }
}
