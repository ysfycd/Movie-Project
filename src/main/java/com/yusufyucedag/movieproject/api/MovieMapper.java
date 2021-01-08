package com.yusufyucedag.movieproject.api;

import com.yusufyucedag.movieproject.dto.MovieCreateDTO;
import com.yusufyucedag.movieproject.dto.MovieViewDTO;
import com.yusufyucedag.movieproject.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "movieUrl", source = "movie.url")
    MovieViewDTO toDTO(Movie movie);
    
    Movie toEntity(MovieCreateDTO dto);

}
