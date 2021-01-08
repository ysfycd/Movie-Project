package com.yusufyucedag.movieproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusufyucedag.movieproject.model.Movie;

/**
 * 
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	boolean existsMovieByMovieName(String movieName);

}
