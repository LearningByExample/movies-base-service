package org.learning.by.example.movies.baseservice.repositories;

import org.learning.by.example.movies.baseservice.model.Movie;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.DefaultQueryMappingConfiguration;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class MappingConfiguration extends DefaultQueryMappingConfiguration {
    MappingConfiguration(final RowMapper<Movie> movieMapper) {
        super();
        registerRowMapper(Movie.class, movieMapper);
    }
}
