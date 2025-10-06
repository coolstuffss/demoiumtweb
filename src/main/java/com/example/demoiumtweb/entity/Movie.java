package com.example.demoiumtweb.entity;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    private Integer id;
    @Nullable
    private String name;
    @Nullable
    private String date;
    @Nullable
    private String tagline;
    @Nullable
    private String description;
    @Nullable
    private Integer minute;
    @Nullable
    private Float rating;
}
