package com.yusufyucedag.movieproject.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
 
/**
 * 
 * @author YUSUF YÜCEDAĞ
 * @Since 1.0
 */

public class AuditorAwareImpl implements AuditorAware<String> {
	
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable("yusuf");
	}
}
