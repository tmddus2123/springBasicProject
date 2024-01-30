package com.example.sy.member;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	
	@PostMapping("/member/test")
	public Map<String, Object> testAjax(@RequestParam Map<String, Object> params) {
		
		System.out.println("params --> " + params);
		
		return params;
	}
	
	@PostMapping("/member/testFetch")
	public Map<String, Object> testFetch(@RequestBody Map<String, Object> params) {
		
		System.out.println("params --> " + params);
		
		return params;
	}
	
	@PostMapping("/member/testXhr")
	public Map<String, Object> testXhr(@RequestBody Map<String, Object> params) {
		
		System.out.println("params --> " + params);
		
		return params;
	}
}
