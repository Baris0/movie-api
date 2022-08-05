package com.movie.backend.service;

import com.movie.backend.dtos.MovieDto;
import com.movie.backend.dtos.converter.MovieDtoConverter;
import com.movie.backend.dtos.request.CreateMovieRequest;
import com.movie.backend.model.Movie;
import com.movie.backend.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    private final MovieDtoConverter movieDtoConverter;

    public MovieDto create(CreateMovieRequest request) {
        Movie movie = new Movie();
        movie.setCreateDate(LocalDate.now());
        movie.setName(request.getName());
        movie.setProducer(request.getProducer());
        movie.setLanguage(request.getLanguage());
        movie.setReleaseDate(request.getReleaseDate());
        movie.setDuration(request.getDuration());
        movie.setImage(request.getImage());
        movie.setCategory(request.getCategory());

        return movieDtoConverter.convert(movieRepository.save(movie));
    }

    public List<MovieDto> getAll() {
        return movieDtoConverter.convert(movieRepository.findAll());
    }

    public List<MovieDto> searchByMovieName(String name) {
        return movieDtoConverter.convert(movieRepository.findAll().stream().filter(movie
                -> movie.getName().contains(name)).collect(Collectors.toList()));
    }

    public List<MovieDto> getMovieByRating(int rating) {
        return movieDtoConverter.convert(movieRepository.findAll().stream().filter(movie
                -> movie.getRating() >= rating).collect(Collectors.toList()));
    }

    public MovieDto delete(String name) {
        Movie movie = movieRepository.findMovieByName(name);
        movieRepository.deleteById(movie.getId());
        return movieDtoConverter.convert(movie);
    }

    public List<MovieDto> getMoviesByCategoryName(String categoryName) {
        return movieDtoConverter.convert(movieRepository.findAll().stream().filter(movie
                -> movie.getCategory().getName().equals(categoryName)).collect(Collectors.toList()));
    }
}
