package com.movie.backend.dtos.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateCategoryRequest {

    @NotBlank
    private String name;
}
