package com.ecinema.ps.api.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
	
	public CacheManager cacheManager() {
		
		return new ConcurrentMapCacheManager("products");
	}

}
