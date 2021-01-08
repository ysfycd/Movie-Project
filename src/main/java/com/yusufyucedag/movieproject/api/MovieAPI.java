package com.yusufyucedag.movieproject.api;

import com.yusufyucedag.movieproject.dto.MovieCreateDTO;
import com.yusufyucedag.movieproject.dto.MovieViewDTO;
import com.yusufyucedag.movieproject.model.Movie;
import com.yusufyucedag.movieproject.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

/**
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MovieAPI {

    private final MovieService movieService;

    private final MovieMapper movieMapper;

    @GetMapping("/v1/movie/{id}")
    public ResponseEntity<MovieViewDTO> getMovieById(@PathVariable("id") Long id) {
        return movieService.getMovieById(id)
            .map(entity -> movieMapper.toDTO(entity))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/v1/movie")
    public ResponseEntity<List<MovieViewDTO>> getAllMovies() {
        final List<MovieViewDTO> movies = movieService.getAllMovies()
            .stream()
            .map(movieMapper::toDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/v1/movie")
    public ResponseEntity<MovieViewDTO> createMovie(@Valid @RequestBody MovieCreateDTO movieCreateDTO) {
        final Movie movie = movieService.createMovie(movieMapper.toEntity(movieCreateDTO));
        return ResponseEntity.ok(movieMapper.toDTO(movie));
    }

}
