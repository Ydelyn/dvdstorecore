package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.DefaultMovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    private final DefaultMovieService movieService;

    public HomeController(DefaultMovieService movieService) {
        this.movieService = movieService;
    }

    public DefaultMovieService getMovieService() {
        return movieService;
    }

    @RequestMapping("/dvdstore-home")
    public @ModelAttribute("movies") List<Movie> displayHome() {
        System.out.println("Tentative d'affichage de l'accueil");
        List<Movie> movies = movieService.getMovieList();
        return movies;
    }
}