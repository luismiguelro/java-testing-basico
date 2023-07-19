package com.platzi.javatesting.movies.model;

import java.util.Objects;

public class Movie {

    private Integer id;
    private String name;

    private String name_director;
    private Integer minutes;
    private Genre genre;

    public Movie(String name,  String nameDirector, Integer minutes, Genre genre) {
        this(null, name, nameDirector, minutes, genre);
    }

    public Movie(Integer id, String name, String nameDirector, Integer minutes, Genre genre) {
        this.id = id;
        this.name = name;
        this.name_director = nameDirector;
        this.minutes = minutes;
        this.genre = genre;
    }



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getName_director() {
        return name_director;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    // metodos iquals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return minutes == movie.minutes && Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genre);
    }
}