package com.example.web.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.web.dto.ResponseDto;

@Service
public class AuthService {
	public Map<String, Object> login(Map<String, Object> param) throws Exception {
		Map<String, Object> result = new HashMap<>();

		return param;
	}
	
	public Map<String, Object> test(ResponseDto param) {
		Map<String, Object> result = new HashMap<>();
		
		return result;
	}
}
