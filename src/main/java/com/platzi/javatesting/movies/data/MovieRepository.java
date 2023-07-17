package com.platzi.javatesting.movies.data;

import com.platzi.javatesting.movies.model.Movie;


import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);

    Collection<Movie> movieByName(String name);
    Collection<Movie> movieByName_opc(String name);
    Collection<Movie> movieByDirector(String name);

    Collection<Movie> movieByDirector_opc(String name);

}