package com.yusufyucedag.movieproject.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.yusufyucedag.movieproject.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

@RequiredArgsConstructor
public final class UniqueMovieNameValidator implements ConstraintValidator<UniqueMovieName, String>{

	private final MovieRepository movieRepository;
	
	@Override
	public boolean isValid(String movieName, ConstraintValidatorContext context) {
		
		return !movieRepository.existsMovieByMovieName(movieName);
	}

}
