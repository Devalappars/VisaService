package com.visa.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;

@SpringBootApplication
@EnableCaching
@EnableMethodCache(basePackages = "com.visa.erp")
@EnableCreateCacheAnnotation
public class VisaErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisaErpApplication.class, args);
	}
}
