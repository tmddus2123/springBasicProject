package com.example.sy.member;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	
	@PostMapping("/member/testFetch")
	public Map<String, Object> testFetch(@RequestBody Map<String, Object> params) {
		
		System.out.println("params --> " + params);
		
		return params;
	}
}
