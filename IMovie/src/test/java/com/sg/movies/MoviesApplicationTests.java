package com.sg.movies;

import com.sg.movies.models.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MoviesApplicationTests
{

  private Movie movie;

  @BeforeEach
  public void setUp() throws Exception
  {
    movie = new Movie();
    movie.setMovieName("Get Smart");
    movie.setMovieDescription("Comedy");
    movie.setPrice(40.00);
    movie.setGenre("Comedy");
  }

  @Test
  @DisplayName("Test Creation of Movie")
  void setAndAdd()
  {
    assertEquals("Get Smart", movie.getMovieName(),
        "Test Creation of Movie");
    assertEquals("Comedy", movie.getMovieDescription(),
        "Test Creation of Movie");
    assertEquals(40.00, movie.getPrice(),
        "Test Creation of Movie");
    assertEquals("Comedy", movie.getGenre(),
        "Test Creation of Movie");
  }

}
