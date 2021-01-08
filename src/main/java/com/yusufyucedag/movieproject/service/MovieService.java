package com.yusufyucedag.movieproject.service;

import com.yusufyucedag.movieproject.model.Movie;

import java.util.List;
import java.util.Optional;

/**
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

public interface MovieService {

    Optional<Movie> getMovieById(Long id);

    Movie getMovieByMovieId(Long moveId);

    List<Movie> getAllMovies();

    Movie createMovie(Movie movie);

}
