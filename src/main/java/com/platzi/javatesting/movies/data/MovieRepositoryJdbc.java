package com.platzi.javatesting.movies.data;

import com.platzi.javatesting.movies.model.Genre;
import com.platzi.javatesting.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object [] args = {id};
        return jdbcTemplate.queryForObject("select * from movies where id =?",args,movieMapper);
    }


    public Collection <Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies (name,name_director,minutes,genre) values (?,?,?,?)",movie.getName(),
               movie.getName_director(), movie.getMinutes(),movie.getGenre().toString());
    }

    @Override
    public Collection<Movie> movieByName(String name) {
        return jdbcTemplate.query("SELECT * FROM MOVIES WHERE LOWER(name) LIKE '%" + name.toLowerCase() + "%'", movieMapper);
    }


    // otro metodo para encontrar peliculas
    @Override
    public Collection<Movie> movieByName_opc(String name){
        List<Movie> collect = findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Collection<Movie> movieByDirector(String name) {
        List<Movie> collect = findAll().stream().filter(movie -> movie.getName_director().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        return collect;
    }

    // opcion 2 para director
    @Override
    public Collection<Movie> movieByDirector_opc(String name) {
        return jdbcTemplate.query("SELECT * FROM MOVIES WHERE LOWER(name_director) LIKE '%" + name.toLowerCase() + "%'", movieMapper);
    }

    @Override
    public Collection<Movie> movieByLength(Integer length) {
        return null;
    }


    //Convertir datos de la BD en objeto java

    private static RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("name_director"),
                    rs.getInt("minutes"),
                    Genre.valueOf(rs.getString("genre")));
}
