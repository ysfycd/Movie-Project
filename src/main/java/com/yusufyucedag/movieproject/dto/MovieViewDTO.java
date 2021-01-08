package com.yusufyucedag.movieproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

@Data
@NoArgsConstructor
public class MovieViewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String movieName;

    private String releaseDate;

    private String director;

    private String movieUrl;

}
