package com.example.demoiumtweb.repository;

import com.example.demoiumtweb.entity.Movie;
import jakarta.persistence.OrderBy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

    Optional<Page<Movie>> findByNameContainingIgnoreCase(String name,
                                                         Pageable pageable);
}
