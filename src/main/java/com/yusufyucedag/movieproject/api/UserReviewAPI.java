package com.yusufyucedag.movieproject.api;

import com.yusufyucedag.movieproject.dto.UserReviewCreateDTO;
import com.yusufyucedag.movieproject.dto.UserReviewViewDTO;
import com.yusufyucedag.movieproject.model.Movie;
import com.yusufyucedag.movieproject.model.UserReview;
import com.yusufyucedag.movieproject.service.MovieService;
import com.yusufyucedag.movieproject.service.UserReviewService;
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
public class UserReviewAPI {

    private final UserReviewService userReviewService;

    private final MovieService movieService;

    private final UserReviewMapper userReviewMapper;

    @PostMapping("/v1/user-review")
    public ResponseEntity<UserReviewViewDTO> createUserReview(@Valid @RequestBody UserReviewCreateDTO userReviewCreateDTO) {
        final Movie movie = movieService.getMovieByMovieId(userReviewCreateDTO.getMovieId());
        UserReview userReviewToCreate = userReviewMapper.toEntity(userReviewCreateDTO);
        userReviewToCreate.setMovie(movie);
        final UserReview createdUserReview = userReviewService.createUserReview(userReviewToCreate);
        return ResponseEntity.ok(userReviewMapper.toDTO(createdUserReview));
    }

    @GetMapping("v1/user-review/all/{movieId}")
    public ResponseEntity<List<UserReviewViewDTO>> getAllUserReviewByMovieId(@PathVariable("movieId") Long moveId) {
        List<UserReviewViewDTO> userReviewViewDTOS = userReviewService.getAllUserReviewByMovieId(moveId)
            .stream()
            .map(userReviewMapper::toDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(userReviewViewDTOS);

    }

}
