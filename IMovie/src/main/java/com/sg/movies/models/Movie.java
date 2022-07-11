package com.sg.movies.models;

import java.time.LocalDate;
import java.util.Objects;

public class Movie {

    private int movieId;
    private String movieName;
    private Double price;
    private String genre;
    private LocalDate releaseDate;
    private String producedBy;
    private String pictureURL;
    private String trailerURL;
    private String movieDescription;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getProducedBy() {
        return producedBy;
    }

    public void setProducedBy(String producedBy) {
        this.producedBy = producedBy;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieId == movie.movieId && Objects.equals(movieName, movie.movieName) && Objects.equals(price, movie.price) && Objects.equals(genre, movie.genre) && Objects.equals(releaseDate, movie.releaseDate) && Objects.equals(producedBy, movie.producedBy) && Objects.equals(pictureURL, movie.pictureURL) && Objects.equals(trailerURL, movie.trailerURL) && Objects.equals(movieDescription, movie.movieDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, movieName, price, genre, releaseDate, producedBy, pictureURL, trailerURL, movieDescription);
    }
}
