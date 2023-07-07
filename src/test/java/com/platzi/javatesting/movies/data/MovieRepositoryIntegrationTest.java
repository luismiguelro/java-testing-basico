package com.platzi.javatesting.movies.data;

import com.platzi.javatesting.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static com.platzi.javatesting.movies.model.Genre.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {
    @Test
    public void load_all_movies() throws SQLException {
        // conexion bd
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        //Script bd - Ejecutar
        ScriptUtils.executeSqlScript(dataSource.getConnection(),new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //  crear repositorio
        MovieRepositoryJdbc movieRepository = new MovieRepositoryJdbc(jdbcTemplate);

        // recuperar las peliculas
        Collection<Movie> movies = movieRepository.findAll();

        // comprobar
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "Matrix", 136, ACTION)
        )));
    }
}