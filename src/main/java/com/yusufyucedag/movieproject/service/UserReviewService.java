package com.yusufyucedag.movieproject.service;

import com.yusufyucedag.movieproject.model.UserReview;

import java.util.List;

/**
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

public interface UserReviewService {

    UserReview createUserReview(UserReview userReview);

    List<UserReview> getAllUserReviewByMovieId(Long moveId);

}
