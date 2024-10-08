package com.example.web.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.Filter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class CustomRequestBodyFilter implements Filter {

    private final ObjectMapper objectMapper;

    public CustomRequestBodyFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 요청의 Content-Type이 JSON일 때만 처리
        if (request.getContentType() != null && request.getContentType().contains("application/json")) {
            // CustomRequestWrapper로 요청을 감싼다.
            CustomRequestWrapper requestWrapper = new CustomRequestWrapper((HttpServletRequest) request);
            
            // 요청 본문을 읽고, 문자열로 변환
            String body = new String(requestWrapper.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

            // JSON으로 변환하여 원하는 대로 값을 수정
            Map<String, Object> jsonMap = objectMapper.readValue(body, Map.class);
            jsonMap.put("newField", "newValue");  // 예시로 필드 추가
            
            // 수정된 JSON을 다시 문자열로 변환
            String updatedBody = objectMapper.writeValueAsString(jsonMap);
            
            // 수정된 본문을 다시 설정
            requestWrapper.setRequestBody(updatedBody.getBytes(StandardCharsets.UTF_8));

            // 필터 체인에 수정된 요청을 전달
            chain.doFilter(requestWrapper, response);
        } else {
            // JSON이 아닌 요청은 그대로 전달
            chain.doFilter(request, response);
        }
	}
}
