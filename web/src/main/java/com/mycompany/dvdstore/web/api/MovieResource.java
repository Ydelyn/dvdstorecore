package com.mycompany.dvdstore.web.api;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.DefaultMovieService;
import com.mycompany.dvdstore.web.form.MovieForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    private final DefaultMovieService movieService;

    public MovieResource(DefaultMovieService movieService) {
        this.movieService = movieService;
    }

    public DefaultMovieService getMovieService() {
        return movieService;
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping
    public List<Movie> list() {
        return movieService.getMovieList();
    }

    @PostMapping
    public Movie add(@RequestBody Movie movie) {
        return movieService.registerMovie(movie);
    }
}
