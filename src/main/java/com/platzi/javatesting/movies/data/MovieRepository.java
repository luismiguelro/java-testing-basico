package com.platzi.javatesting.movies.data;

import com.platzi.javatesting.movies.model.Movie;


import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}