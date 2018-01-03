package com.herohuang.doctor.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by acheron on 03/05/2017.
 */
@Component
public class Config {
	@Value("${cache.properties.path}")
	private String cachePropertiesPath;

	public String getCachePropertiesPath() {
		return cachePropertiesPath;
	}

	public void setCachePropertiesPath(String cachePropertiesPath) {
		this.cachePropertiesPath = cachePropertiesPath;
	}
}
