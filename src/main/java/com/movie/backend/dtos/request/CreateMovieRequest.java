package com.movie.backend.dtos.request;

import com.movie.backend.model.Category;
import lombok.Data;

@Data
public class CreateMovieRequest {

    private String name;
    private String description;
    private String producer;
    private String releaseDate;
    private String language;
    private String duration;
    private String image;
    Category category;
}
