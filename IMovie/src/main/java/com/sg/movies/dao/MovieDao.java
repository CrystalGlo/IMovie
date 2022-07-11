package com.sg.movies.dao;

import com.sg.movies.models.Movie;

import java.util.List;

public interface MovieDao {

    Movie getMovieById(int movieId);
    List<Movie> getAllMovies();
    List<Movie> getCartMovies();
    Movie addMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovieById(int movieId);
    void deleteFromCartById(int movieId);
    void addToBasket(Movie movie);

    List<Movie> search(String keyword);

}
