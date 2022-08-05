package com.movie.backend.service;

import com.movie.backend.dtos.CategoryDto;
import com.movie.backend.dtos.converter.CategoryDtoConverter;
import com.movie.backend.dtos.request.CreateCategoryRequest;
import com.movie.backend.model.Category;
import com.movie.backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryDtoConverter categoryDtoConverter;

    public CategoryDto save(CreateCategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());

        return categoryDtoConverter.convert(categoryRepository.save(category));
    }

    public List<CategoryDto> getAll() {
        return categoryDtoConverter.convert(categoryRepository.findAll());
    }

    public CategoryDto getCategoryByName(String name) {
        return categoryDtoConverter.convert(categoryRepository.findCategoryByName(name));
    }

    public CategoryDto delete(String name) {
        Category category = categoryRepository.findCategoryByName(name);
        categoryRepository.deleteById(category.getId());
        return categoryDtoConverter.convert(category);
    }
}
