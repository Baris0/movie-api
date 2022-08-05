package com.movie.backend.dtos.converter;

import com.movie.backend.dtos.MovieDto;
import com.movie.backend.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieDtoConverter {

    public MovieDto convert(Movie movie) {
        return new MovieDto(movie.getName(),
                movie.getRating(),
                movie.getProducer(),
                movie.getReleaseDate(),
                movie.getLanguage(),
                movie.getDuration(),
                movie.getImage(),
                movie.getCategory());
    }

    public List<MovieDto> convert(List<Movie> movies) {
        return movies.stream().map(this::convert).collect(Collectors.toList());
    }
}
