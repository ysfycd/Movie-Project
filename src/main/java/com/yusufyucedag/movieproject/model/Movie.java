package com.yusufyucedag.movieproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "movies")
public class Movie extends BaseAudit{
	
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(name = "movie_names" , nullable = false, length = 50, unique = true)
	private String movieName;
	
	@Column(name = "release_dates" , nullable = false, length = 50)
	private String releaseDate;
	
	@Column(name = "directors" , nullable = false, length = 50)
	private String director;
	
	@Column(name = "urls" , nullable = false, length = 50)
	private String url;
	
	@OneToMany
	@JoinColumn(name = "movie_id")
	private Set <UserReview> reviews = new HashSet<UserReview>();

	public Movie(String movieName, String releaseDate, String director, String url) {
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.director = director;
		this.url = url;
	}
}
