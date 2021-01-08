package com.yusufyucedag.movieproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

@Data
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@NoArgsConstructor
@Entity
@Table(name = "user_reviews")
public class UserReview extends BaseAudit{

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(name = "reviewers", nullable = false , length = 50)
	private String reviewer;

	@Column(name = "review_details", nullable = false , length = 200)
	private String reviewDetail;

	@Column(name = "review_dates", nullable = false)
	private Date reviewDate;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;

	public UserReview(String reviewer, String reviewDetail, Date reviewDate, Movie movie) {
		this.reviewer = reviewer;
		this.reviewDetail = reviewDetail;
		this.reviewDate = reviewDate;
		this.movie = movie;
	}
}
