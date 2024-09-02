package com.example.web.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration

@RequiredArgsConstructor
// lombok에서 자동으로 의존성 주입해주는 어노테이션
public class WebMvcConfig implements WebMvcConfigurer{
	private final CustomArgumentResolver customArgumentResolver;
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addArgumentResolvers(resolvers);
	}
}
