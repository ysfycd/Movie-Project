/**
 * 
 */
package com.yusufyucedag.movieproject.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { UniqueMovieNameValidator.class })
public @interface UniqueMovieName {
	
	String message() default "{movieproject.constraints.UniqueMovieName.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
