package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService {

    private final MovieRepositoryInterface movieRepository;

    public DefaultMovieService(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public void registerMovie (Movie movie) {
        movieRepository.add(movie);
    }

    public List<Movie> getMovieList() {
        return movieRepository.list();
    }

}
