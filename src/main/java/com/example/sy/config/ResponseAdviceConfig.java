package com.example.sy.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.example.sy.dto.ResponseDto;

import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice(basePackages = "com.example")
public class ResponseAdviceConfig implements ResponseBodyAdvice {

	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		// TODO Auto-generated method stub
		
		HttpServletResponse servletResponse =
                ((ServletServerHttpResponse) response).getServletResponse();

        int status = servletResponse.getStatus();
        HttpStatus resolve = HttpStatus.resolve(status);

        if (resolve == null) {
            return body;
        }

        System.out.println(status);
        
        if (resolve.is2xxSuccessful()) {
            return new ResponseDto(status, "success",  body);
        }

        return body;
	}

}
