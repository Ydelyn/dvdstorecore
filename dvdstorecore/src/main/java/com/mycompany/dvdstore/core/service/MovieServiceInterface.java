package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {
    Iterable<Movie> getMovieList();
    Movie getMovieById(Long id);
}
