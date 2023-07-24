package com.platzi.javatesting.movies.service;

import com.platzi.javatesting.movies.data.MovieRepository;
import com.platzi.javatesting.movies.model.Genre;
import com.platzi.javatesting.movies.model.Movie;
import org.jetbrains.annotations.NotNull;

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

    // Cumple con la primera condicion que valide
    public Collection <Movie> findMoviesByTemplate (Movie template){

        return movieRepository.findAll().stream().filter(
                movie -> {
                    return movie.getName().equalsIgnoreCase(template.getName()) ||
                            movie.getName_director().equalsIgnoreCase(template.getName_director()) ||
                            movie.getGenre().equals(template.getGenre()) ||
                            movie.getMinutes().equals(template.getMinutes());
                }).collect(Collectors.toList());
    }

    // otra opcion de template: se pueden agg diferentes combinaciones
    public Collection <Movie> findByTemplate(Movie template){
        Collection<Movie> movies = movieRepository.findAll();


        if (template.getId() == null) {
            movies = templateFilter(template, movies);
        } else {
            movies = movies.stream().filter(movie -> movie.getId() == template.getId()).collect(Collectors.toList());
        }

        return movies;
    }

    // filtrar
    public Collection<Movie> templateFilter(Movie template, Collection<Movie> movies) {
        return movies.stream()
                .filter(movie -> isMatchingName(template, movie))
                .filter(movie -> isMatchingDirector(template, movie))
                .filter(movie -> isMatchingMinutes(template, movie))
                .filter(movie -> isMatchingGenre(template, movie))
                .collect(Collectors.toList());
    }

    private boolean isMatchingName(@NotNull Movie template, Movie movie) {
        return template.getName() == null || movie.getName().toLowerCase().contains(template.getName().toLowerCase());
    }

    private boolean isMatchingDirector(@NotNull Movie template, Movie movie) {
        return template.getName_director() == null || movie.getName_director().toLowerCase().contains(template.getName_director().toLowerCase());
    }

    private boolean isMatchingMinutes(@NotNull Movie template, Movie movie) {
        return template.getMinutes() == null || movie.getMinutes() >= template.getMinutes();
    }

    private boolean isMatchingGenre(@NotNull Movie template, Movie movie) {
        return template.getGenre() == null || movie.getGenre() == template.getGenre();
    }

}