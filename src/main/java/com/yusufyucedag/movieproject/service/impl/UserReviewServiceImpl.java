package com.yusufyucedag.movieproject.service.impl;

import com.yusufyucedag.movieproject.model.Movie;
import com.yusufyucedag.movieproject.model.UserReview;
import com.yusufyucedag.movieproject.repository.UserReviewRepository;
import com.yusufyucedag.movieproject.service.MovieService;
import com.yusufyucedag.movieproject.service.UserReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

@Service
@RequiredArgsConstructor
public class UserReviewServiceImpl implements UserReviewService {

    private final UserReviewRepository userReviewRepository;

    private final MovieService movieService;

    @Override
    @Transactional
    public UserReview createUserReview(UserReview userReview) {
        return userReviewRepository.save(userReview);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserReview> getAllUserReviewByMovieId(Long moveId) {
        final Movie movie = movieService.getMovieByMovieId(moveId);
        return userReviewRepository.findByMovieIdEquals(movie.getId());
    }

}
