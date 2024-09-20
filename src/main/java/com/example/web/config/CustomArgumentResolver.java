package com.example.web.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.example.web.dto.ResponseDto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		Map<String, Object> result = new HashMap<>();
		
		Map<String, String[]> parameterMap = webRequest.getParameterMap();
		
		for(Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue()[0];
			result.put(key, value);
		}
		
	    ResponseDto responseDto = new ResponseDto();
	    responseDto.setBody(result);
	    
		return responseDto;
	}

}
