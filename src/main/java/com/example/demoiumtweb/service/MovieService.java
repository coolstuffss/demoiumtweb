package com.example.demoiumtweb.service;

import com.example.demoiumtweb.repository.MovieRepo;
import com.example.demoiumtweb.service.MovieService;
import com.example.demoiumtweb.entity.Movie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {
    private final MovieRepo movieRepo;

    public List<Movie> findAllMovies(int page, int size) {
        PageRequest limit = PageRequest.of(page, size);
        return movieRepo.findAll(limit).toList();
    }

    public Movie findMovieById(int id) {
        Optional<Movie> movie = movieRepo.findById(id);
        if (movie.isPresent() == true) {
            return movie.get();
        }
        log.info("Movie with id: {} not found", id);
        return null;
    }

    public Page<Movie> findByName(String name,
                                  Pageable pageable) {
        Optional<Page<Movie>> movies = movieRepo
                .findByNameContainingIgnoreCase(name, pageable);
        if (movies.isPresent() == true) {
            return movies.get();
        }
        log.info("Movie with string: {} produced 0 results", name);
        return null;
    }
}
