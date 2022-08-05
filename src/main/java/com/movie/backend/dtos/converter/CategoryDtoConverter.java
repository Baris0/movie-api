package com.movie.backend.dtos.converter;

import com.movie.backend.dtos.CategoryDto;
import com.movie.backend.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CategoryDtoConverter {

    public CategoryDto convert(Category category) {
        return new CategoryDto(category.getName());
    }

    public List<CategoryDto> convert(List<Category> categories) {
        return categories.stream().map(this::convert).collect(Collectors.toList());
    }
}
