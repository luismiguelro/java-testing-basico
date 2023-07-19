package com.platzi.javatesting.movies.service;

import com.platzi.javatesting.movies.data.MovieRepository;
import com.platzi.javatesting.movies.model.Genre;
import com.platzi.javatesting.movies.model.Movie;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    // Donde se almacena las peliculas
    MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Collection <Movie> findMoviesByGenre(Genre genre) {

        return movieRepository.findAll()
                .stream().filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection <Movie> findMoviesByLength(int length) {
        return movieRepository.findAll()
                .stream().filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection <Movie> findMoviesByTemplate (Movie template){

        return movieRepository.findAll().stream().filter(
                movie -> {
                    return movie.getName().equalsIgnoreCase(template.getName()) ||
                            movie.getName_director().equalsIgnoreCase(template.getName_director()) ||
                            movie.getGenre().equals(template.getGenre()) ||
                            movie.getMinutes().equals(template.getMinutes());
                }).collect(Collectors.toList());
    }
}