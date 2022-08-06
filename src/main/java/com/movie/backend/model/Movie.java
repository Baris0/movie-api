package com.movie.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int rating;
    private String description;
    private String producer;
    private String releaseDate;
    private String language;
    private LocalDate createDate;
    private LocalDate updateDate;
    private String duration;
    private String image;
    @ManyToOne(fetch = FetchType.EAGER)
    Category category;
}
