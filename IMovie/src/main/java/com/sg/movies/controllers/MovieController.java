package com.sg.movies.controllers;

import com.sg.movies.dao.MovieDao;
import com.sg.movies.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieDao movieDao;

    @GetMapping("movies")
    public String displayMovies(Model model) {
        List<Movie> movies = movieDao.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("addMovie")
    public String displayAddMovie(Model model){
        return "addMovie";
    }

    @PostMapping("addMovie")
    public String addMovie(HttpServletRequest request) {

        String movieName = request.getParameter("movieName");
        String genre = request.getParameter("genre");
        String producedBy = request.getParameter("producedBy");
        String pictureURL = request.getParameter("pictureURL");
        String trailerURL = request.getParameter("trailerURL");
        String movieDescription = request.getParameter("movieDescription");

        // parsing price
        String providedPrice = request.getParameter("providedPrice");
        Double price = Double.parseDouble(providedPrice);
        // parsing release date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String providedReleaseDate = request.getParameter("providedReleaseDate");
        LocalDate releaseDate = LocalDate.parse(providedReleaseDate, formatter);

        Movie movie = new Movie();
        movie.setMovieName(movieName);
        movie.setGenre(genre);
        movie.setProducedBy(producedBy);
        movie.setPictureURL(pictureURL);
        movie.setTrailerURL(trailerURL);
        movie.setMovieDescription(movieDescription);
        movie.setPrice(price);
        movie.setReleaseDate(releaseDate);
        movieDao.addMovie(movie);

        return "redirect:/movies";
    }

    @GetMapping("addToBasket")
    public String addToBasketHttpServletRequest(HttpServletRequest request, Model model)
    {
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        Movie movie = movieDao.getMovieById(movieId);

        movieDao.addToBasket(movie);
        return "redirect:/movies";
    }

    @GetMapping("editMovie")
    public String displayEditMovie(HttpServletRequest request, Model model){
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        Movie movie = movieDao.getMovieById(movieId);

        model.addAttribute("movie",movie);
        return "editMovie";
    }

    @PostMapping("editMovie")
    public String performEditMovie(HttpServletRequest request) {
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        Movie movie = movieDao.getMovieById(movieId);

        // parsing price
        String providedPrice = request.getParameter("providedPrice");
        Double price = Double.parseDouble(providedPrice);
        // parsing release date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String providedReleaseDate = request.getParameter("providedReleaseDate");
        LocalDate releaseDate = LocalDate.parse(providedReleaseDate, formatter);

        movie.setMovieName(request.getParameter("movieName"));
        movie.setGenre(request.getParameter("genre"));
        movie.setProducedBy(request.getParameter("producedBy"));
        movie.setPictureURL(request.getParameter("pictureURL"));
        movie.setTrailerURL(request.getParameter("trailerURL"));
        movie.setMovieDescription(request.getParameter("movieDescription"));
        movie.setPrice(price);
        movie.setReleaseDate(releaseDate);

        movieDao.updateMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("detailsMovie")
    public String displayMovieDetails(HttpServletRequest request, Model model) {
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        Movie movie = movieDao.getMovieById(movieId);

        model.addAttribute("movie",movie);
        return "detailsMovie";
    }

    @GetMapping("deleteMovie")
    public String deleteMovie(HttpServletRequest request) {
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        movieDao.deleteMovieById(movieId);
        return "redirect:/movies";
    }

    @GetMapping("deleteMovieFromCart")
    public String deleteMovieFromCart(HttpServletRequest request) {
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        movieDao.deleteFromCartById(movieId);
        return "redirect:/cart";
    }

    @GetMapping("cart")
    public String displayCart(Model model) {
        List<Movie> cart = movieDao.getCartMovies();
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("search")
    public String search(@RequestParam("keyword") String keyword, Model model){
        //System.out.println("keyword: " + keyword);
        List<Movie> search_result = movieDao.search(keyword);
        model.addAttribute("search_result", search_result);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageTitle", "Results for '" + keyword + "'");
        return "search";
    }
}
