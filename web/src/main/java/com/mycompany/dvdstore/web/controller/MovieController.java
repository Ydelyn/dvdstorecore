package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.DefaultMovieService;
import com.mycompany.dvdstore.web.form.MovieForm;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private final DefaultMovieService movieService;

    public MovieController(DefaultMovieService movieService) {
        this.movieService = movieService;
    }

    public DefaultMovieService getMovieService() {
        return movieService;
    }

   @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-movie-form";
        }
        Movie movie = new Movie();
        movie.setId(movieForm.getId());
        movie.setTitle(movieForm.getTitle());
        movie.setGenre(movieForm.getGenre());
        if (movieForm.getDescription().isBlank()) {
            movie.setDescription(null);
        }
        else {
            movie.setDescription(movieForm.getDescription());
        }
        movieService.registerMovie(movie);
        return "movie-added";
    }
}
