package com.example.web.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.dto.ResponseDto;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody Map<String, Object> param) throws Exception {

		return authService.login(param);
	}
	
	@PostMapping("/test")
	public Map<String, Object> test(ResponseDto param) {
		System.out.println("param --> " + param.getBody());
		
		return authService.test(param);
	}
}
