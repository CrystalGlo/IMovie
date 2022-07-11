package com.sg.movies.dao;

import com.sg.movies.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MovieDaoDB implements MovieDao{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Movie getMovieById(int movieId) {
        try{
            final String GET_MOVIE_BY_ID = "SELECT * FROM movie WHERE movieId = ?";
            return jdbc.queryForObject(GET_MOVIE_BY_ID, new MovieMapper(), movieId);
        } catch (DataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Movie> getAllMovies() {
        final String GET_ALL_MOVIES = "SELECT * FROM movie";
        return jdbc.query(GET_ALL_MOVIES, new MovieMapper());
    }

    @Override
    public List<Movie> getCartMovies() {
        final String GET_CART_MOVIES = "SELECT * FROM movie " +
                "INNER JOIN purchasedMovie ON movie.movieId = purchasedMovie.movieId";
        return jdbc.query(GET_CART_MOVIES, new MovieMapper());
    }

    @Override
    @Transactional
    public void addToBasket(Movie movie)
    {
        final String INSERT_MOVIE = "INSERT IGNORE INTO purchasedMovie(movieId) " +
            "VALUES(?)";
        jdbc.update(INSERT_MOVIE, movie.getMovieId());
    }

    @Override
    public List<Movie> search(String keyword) {
        final String SEARCH_KEYWORD = "SELECT * FROM movie WHERE " +
                "MATCH(movieName, genre, producedBy, movieDescription) " +
                "AGAINST(?);";
        return jdbc.query(SEARCH_KEYWORD, new MovieMapper(), keyword);
    }

    @Override
    @Transactional
    public Movie addMovie(Movie movie){

        final String INSERT_MOVIE = "INSERT INTO movie(movieName, price, genre, " +
                "releaseDate, producedBy, pictureURL, trailerURL, movieDescription) " +
                "VALUES(?,?,?,?,?,?,?,?)";

        jdbc.update(INSERT_MOVIE,
                movie.getMovieName(),
                movie.getPrice(),
                movie.getGenre(),
                movie.getReleaseDate(),
                movie.getProducedBy(),
                movie.getPictureURL(),
                movie.getTrailerURL(),
                movie.getMovieDescription());

        //int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        //movie.setMovieId(newId);
        return movie;
    }

    @Override
    public void updateMovie(Movie movie) {
        final String UPDATE_MOVIE = "UPDATE movie SET movieName = ?, price = ?, " +
                "genre = ?, releaseDate = ?, producedBy = ?, pictureURL = ?, " +
                "trailerURL = ?, movieDescription = ? WHERE movieId = ?";

        jdbc.update(UPDATE_MOVIE,
                movie.getMovieName(),
                movie.getPrice(),
                movie.getGenre(),
                movie.getReleaseDate(),
                movie.getProducedBy(),
                movie.getPictureURL(),
                movie.getTrailerURL(),
                movie.getMovieDescription(),
                movie.getMovieId());

    }

    @Override
    @Transactional
    public void deleteMovieById(int movieId) {
        final String DELETE_MOVIE = "DELETE FROM movie WHERE movieId = ?";
        jdbc.update(DELETE_MOVIE, movieId);
    }

    @Override
    public void deleteFromCartById(int movieId) {
        final String DELETE_MOVIE_FROM_CART = "DELETE FROM purchasedMovie WHERE movieId = ?";
        jdbc.update(DELETE_MOVIE_FROM_CART, movieId);
    }

    // mapper
    public static final class MovieMapper implements RowMapper<Movie>{

        @Override
        public Movie mapRow(ResultSet rs, int index) throws SQLException {
            Movie movie = new Movie();
            movie.setMovieId(rs.getInt("movieId"));
            movie.setMovieName(rs.getString("movieName"));
            movie.setGenre(rs.getString("genre"));
            movie.setProducedBy(rs.getString("producedBy"));
            movie.setPictureURL(rs.getString("pictureURL"));
            movie.setTrailerURL(rs.getString("trailerURL"));
            movie.setMovieDescription(rs.getString("movieDescription"));
            movie.setPrice(rs.getDouble("price"));
            movie.setReleaseDate(rs.getDate("releaseDate").toLocalDate());

            return movie;
        }
    }



}
