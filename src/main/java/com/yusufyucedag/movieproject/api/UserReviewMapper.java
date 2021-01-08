package com.yusufyucedag.movieproject.api;

import com.yusufyucedag.movieproject.dto.UserReviewCreateDTO;
import com.yusufyucedag.movieproject.dto.UserReviewViewDTO;
import com.yusufyucedag.movieproject.model.UserReview;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Date;

@Mapper(componentModel = "spring")
public abstract class UserReviewMapper {

    @Mapping(target = "movieUrl", ignore = true)
    abstract UserReviewViewDTO toDTO(UserReview userReview);

    @Mapping(target = "movie", ignore = true)
    @Mapping(target = "id", ignore = true)
    abstract UserReview toEntity(UserReviewCreateDTO dto);

    @AfterMapping
    void setMovieUrl(UserReview userReview, @MappingTarget UserReviewViewDTO userReviewViewDTO) {
        userReviewViewDTO.setMovieUrl(userReview.getMovie().getUrl());
    }

    @AfterMapping
    void setUserReviewDate(UserReviewCreateDTO userReviewCreateDTO, @MappingTarget UserReview userReview) {
        userReview.setReviewDate(new Date());
    }

}
