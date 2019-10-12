package com.zadatak.zadatak;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZadatakController {
	
	@GetMapping("/hello")
	public String helloPage() {
		return "Hello!";
	}

}
