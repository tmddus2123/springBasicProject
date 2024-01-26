package com.example.sy.member;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	
	@PostMapping("/member/test")
	public Map<String, Object> testAjax(@RequestParam Map<String, Object> params) {

		return params;
	}
}
