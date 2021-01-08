package com.yusufyucedag.movieproject.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

@Data
public final class UserReviewViewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String reviewer;

    private String reviewDetail;

    private Date reviewDate;

    private String movieUrl;
    
}
