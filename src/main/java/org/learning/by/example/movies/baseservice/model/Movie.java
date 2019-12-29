package org.learning.by.example.movies.baseservice.model;

import java.util.List;
import java.util.Objects;

public class Movie {
    private final Integer id;
    private final String title;
    private final Integer year;
    private final List<String> genres;

    public Movie(final Integer id, final String title, final Integer year, List<String> genres) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genres = genres;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public List<String> getGenres() {
        return genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return id.equals(movie.id) &&
                title.equals(movie.title) &&
                year.equals(movie.year) &&
                genres.equals(movie.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, genres);
    }
}
