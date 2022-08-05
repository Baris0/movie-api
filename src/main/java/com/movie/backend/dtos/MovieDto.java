package com.movie.backend.dtos;

import com.movie.backend.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieDto {

    private String name;
    private int rating;
    private String producer;
    private String releaseDate;
    private String language;
    private String duration;
    private String image;
    Category category;
}
