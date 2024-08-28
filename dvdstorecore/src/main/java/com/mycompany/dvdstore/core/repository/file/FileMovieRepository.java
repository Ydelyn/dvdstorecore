package com.mycompany.dvdstore.core.repository.file;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.Optional;
import java.util.stream.StreamSupport;

//@Repository
public class FileMovieRepository implements MovieRepositoryInterface {

    private FileMovieRepository movieRepository;

    @Value("${movies.file.location}")
    private File file;

    public FileMovieRepository getMovieRepository() {
        return movieRepository;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Movie save(Movie movie) {

        FileWriter writer;
        try{
            long lastId= StreamSupport.stream(findAll().spliterator(), false).map(Movie::getId).max(Long::compare).orElse(0L);
            movie.setId(lastId+1);
            writer=new FileWriter(file,true);
            writer.write(movie.getId()+";"+movie.getTitle()+";"+movie.getGenre()+";"+movie.getDescription()+"\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return movie;
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        final Movie movie = new Movie();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                final String[] allProperties = line.split("\\;");
                final long nextMovieId=Long.parseLong(allProperties[0]);
                if (nextMovieId==id) {
                    movie.setTitle(allProperties[1]);
                    movie.setGenre(allProperties[2]);
                    movie.setDescription(allProperties[3]);
                    return Optional.of(movie);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        movie.setTitle("UNKNOWN");
        movie.setGenre("UNKNOWN");
        movie.setDescription("UNKNOWN");
        return Optional.of(movie);
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Movie entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }
}
