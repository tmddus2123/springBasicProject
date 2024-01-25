package com.example.sy.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/main")
	public String Home() {
		//test

		return "main";
	}
}
