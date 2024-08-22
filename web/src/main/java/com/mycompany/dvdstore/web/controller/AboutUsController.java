package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.core.service.DefaultMovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

    private final DefaultMovieService movieService;

    public AboutUsController(DefaultMovieService movieService) {
        this.movieService = movieService;
    }

    public DefaultMovieService getMovieService() {
        return movieService;
    }

    @GetMapping("/about-us")
    public String displayAboutUs() {
        System.out.println("Tentative d'affichage de à-propos");
        return "about-us";
    }
}