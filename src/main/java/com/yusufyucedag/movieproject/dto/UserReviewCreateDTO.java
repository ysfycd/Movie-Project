package com.yusufyucedag.movieproject.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

@Data
public class UserReviewCreateDTO {
	
	@NotNull(message = "{movieproject.constraints.reviewer.NotNull.message}")
	@Size(min = 4, max = 24, message = "{movieproject.constraints.reviewer.Size.message}")
	private String reviewer;
	
	@NotNull(message = "{movieproject.constraints.reviewDetail.NotNull.message}")
	@Size(min = 1, max = 200, message = "{movieproject.constraints.reviewDetail.Size.message}")
	private String reviewDetail;
	
	@NotNull(message = "{movieproject.constraints.movieId.NotNull.message}")
	private long movieId;
}
