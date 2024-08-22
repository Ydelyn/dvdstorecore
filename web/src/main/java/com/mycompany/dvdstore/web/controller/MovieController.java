package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.DefaultMovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Scanner;

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

    @RequestMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movie-details";
    }
}
