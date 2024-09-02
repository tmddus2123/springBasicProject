package com.example.web.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@RequestMapping("/login")
	public Map<String, Object> login(@RequestBody Map<String, Object> param) throws Exception {

		return authService.login(param);
	}
}
