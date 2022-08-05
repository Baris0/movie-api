package com.movie.backend.controller;

import com.movie.backend.dtos.MovieDto;
import com.movie.backend.dtos.request.CreateMovieRequest;
import com.movie.backend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDto> save(@RequestBody CreateMovieRequest request) {
        return new ResponseEntity<>(movieService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<MovieDto>> searchByMovieName(@PathVariable("name") String name) {
        return new ResponseEntity<>(movieService.searchByMovieName(name), HttpStatus.OK);
    }

    @GetMapping("/{rating}")
    public ResponseEntity<List<MovieDto>> getMovieByRating(@PathVariable("rating") int rating) {
        return new ResponseEntity<>(movieService.getMovieByRating(rating), HttpStatus.OK);
    }

    @DeleteMapping("{name}")
    public ResponseEntity<MovieDto> delete(@PathVariable("name") String name) {
        return new ResponseEntity<>(movieService.delete(name), HttpStatus.OK);
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<MovieDto>> getMoviesByCategoryName(@PathVariable("categoryName") String categoryName) {
        return new ResponseEntity<>(movieService.getMoviesByCategoryName(categoryName), HttpStatus.OK);
    }
}
