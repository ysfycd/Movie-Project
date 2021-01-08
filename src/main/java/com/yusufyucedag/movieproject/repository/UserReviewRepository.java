package com.yusufyucedag.movieproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusufyucedag.movieproject.model.UserReview;

/**
 * 
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
	
	List<UserReview> findByMovieIdEquals(Long moveId);

}
