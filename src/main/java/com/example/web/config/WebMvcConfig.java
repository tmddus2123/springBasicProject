package com.example.web.config;

import java.util.List;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
// lombok에서 자동으로 의존성 주입해주는 어노테이션
public class WebMvcConfig implements WebMvcConfigurer {
	
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		// TODO Auto-generated method stub
		resolvers.add(new CustomArgumentResolver());
	}
	
	@Bean(name = "customRequestFilter")
    public Filter customRequestBodyFilter(ObjectMapper objectMapper) {
        return new CustomRequestBodyFilter(objectMapper);
    }
}
