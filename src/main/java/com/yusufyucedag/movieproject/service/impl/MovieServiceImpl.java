package com.yusufyucedag.movieproject.service.impl;

import com.yusufyucedag.movieproject.exception.NotFoundException;
import com.yusufyucedag.movieproject.model.Movie;
import com.yusufyucedag.movieproject.repository.MovieRepository;
import com.yusufyucedag.movieproject.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    /*
     * For find and update methods
     */
    private Movie getMovieByIdCommon(Long id) {

        return movieRepository.findById(id). //
            orElseThrow(() -> new NotFoundException("Movie Not Found Exception"));
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<Movie> getMovieById(Long id) {
        return Optional.ofNullable(getMovieByIdCommon(id));
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Movie getMovieByMovieId(Long moveId) {
        return getMovieByIdCommon(moveId);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    @Transactional
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }


}
