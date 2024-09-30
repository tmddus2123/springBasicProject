package com.example.web.config;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomRequestInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
        String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

		System.out.println("interceptor " + body);
		// TODO Auto-generated method stub
		request.setAttribute(body, body);
		return true;
	}
}
