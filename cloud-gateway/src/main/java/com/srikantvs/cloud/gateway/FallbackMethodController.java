package com.srikantvs.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {
	@GetMapping(value="/userServiceFallback")
	public String userServiceFallbackMethod() {
		return "User Service is taking longer than expected... please try again later";
	}
	
	@GetMapping(value="/departmentServiceFallback")
	public String departmentServiceFallbackMethod() {
		return "Department Service is taking longer than expected... please try again later";
	}
}
