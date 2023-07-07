package com.platzi.javatesting.movies.data;

import com.platzi.javatesting.movies.model.Genre;
import com.platzi.javatesting.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        return null;
    }


    public Collection <Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

    }

    // Crear pelicula a partir de la BD

    private static RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    Genre.valueOf(rs.getString("genre")));
}
