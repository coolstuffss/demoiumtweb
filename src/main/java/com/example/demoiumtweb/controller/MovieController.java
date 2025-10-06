package com.example.demoiumtweb.controller;

import com.example.demoiumtweb.entity.Movie;
import com.example.demoiumtweb.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/get_all_movies")
    public ResponseEntity<List<Movie>> getAllMovies(
            @RequestParam(value = "n_page", defaultValue = "0") int page_number,
            @RequestParam(value = "size", defaultValue = "500") int size) {
        return ResponseEntity.ok().body(
                movieService.findAllMovies(page_number, size));
    }

    @GetMapping("/get_movie_by_id")
    public ResponseEntity<Movie> getMovieById(
            @RequestParam(value = "id", defaultValue = "1") int movie_id) {
        return ResponseEntity.ok().body(movieService.findMovieById(movie_id));
    }

    @GetMapping("/get_movies_by_name")
    public ResponseEntity<Page<Movie>> getMovieByName(
            @RequestParam(value = "name", defaultValue = "") String movie_name,
            @RequestParam(value = "page_num", defaultValue = "0") int page_num,
            @RequestParam(value = "page_sz", defaultValue = "25") int page_sz) {
        Pageable pageable = PageRequest.
                of(page_num, page_sz, Sort.by("id"));

        return ResponseEntity.ok().
                body(movieService.findByName(movie_name, pageable));
    }
}
