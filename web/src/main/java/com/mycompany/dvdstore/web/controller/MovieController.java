package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.DefaultMovieService;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MovieController {

    private final DefaultMovieService movieService;

    public MovieController(DefaultMovieService movieService) {
        this.movieService = movieService;
    }

    public DefaultMovieService getMovieService() {
        return movieService;
    }

    public void addUsingConsole() {
        System.out.println( "Write the title of the movie:" );
        Scanner sc=new Scanner(System.in);
        String title=sc.nextLine();
        System.out.println( "Write the genre of the movie:" );
        sc=new Scanner(System.in);
        String genre=sc.nextLine();
        Movie movie=new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);
        movieService.registerMovie(movie);
    }
}
