package org.learning.by.example.movies.baseservice.mapper;

import org.learning.by.example.movies.baseservice.model.Movie;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class MovieMapper implements RowMapper<Movie> {
    final Pattern pattern = Pattern.compile("(.*) \\((\\d*)\\)");

    @Override
    public Movie mapRow(final ResultSet resultSet, final int i) throws SQLException {
        final String rowTile = resultSet.getString("title");

        final String realTitle;
        final int year;

        final Matcher matcher = pattern.matcher(rowTile);
        if (matcher.find()) {
            realTitle = matcher.group(1);
            year = Integer.parseInt(matcher.group(2));
        } else {
            realTitle = rowTile;
            year = 1900;
        }

        final String[] genres = resultSet.getString("genres").split("\\|");
        final List<String> genresList = Arrays.stream(genres).filter(s -> !s.isEmpty()).collect(Collectors.toList());
        final int id = resultSet.getInt("id");

        return new Movie(id, realTitle, year, genresList);
    }
}
