package com.mycompany.dvdstore.core.repository.memory;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

    private MemoryMovieRepository movieRepository;

    public MemoryMovieRepository getMovieRepository() {
        return movieRepository;
    }

    private List movies=new ArrayList<>();

    public void add (Movie movie) {
        movies.add(movie);
        System.out.println("The movie " +movie.getTitle() + " has been added with the genre " +movie.getGenre());
    }

    @Override
    public List<Movie> list() {
        throw new UnsupportedOperationException();
    }
}
