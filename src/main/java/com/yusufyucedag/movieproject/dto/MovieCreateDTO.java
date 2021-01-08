package com.yusufyucedag.movieproject.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.yusufyucedag.movieproject.validator.UniqueMovieName;

import lombok.Data;

/**
 * 
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

@Data
public class MovieCreateDTO {
	
	
	@NotNull(message = "{movieproject.constraints.movieName.NotNull.message}")
	@Size(min = 4, max = 24, message = "{movieproject.constraints.movieName.Size.message}")
	@UniqueMovieName
	private  String movieName;
	
	@NotNull(message = "{movieproject.constraints.releaseDate.NotNull.message}")
	@Size(min = 4, max = 24, message = "{movieproject.constraints.releaseDate.Size.message}")
	private  String releaseDate;

	@NotNull(message = "{movieproject.constraints.director.NotNull.message}")
	@Size(min = 4, max = 24, message = "{movieproject.constraints.director.Size.message}")
	private  String director;

	@NotNull(message = "{movieproject.constraints.url.NotNull.message}")
	@Size(min = 4, max = 24, message = "{movieproject.constraints.url.Size.message}")
	private  String url;
}
