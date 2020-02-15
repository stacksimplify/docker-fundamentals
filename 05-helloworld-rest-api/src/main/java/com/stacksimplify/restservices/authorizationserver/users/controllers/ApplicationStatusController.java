package com.stacksimplify.restservices.authorizationserver.users.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class ApplicationStatusController {

	@GetMapping("/status")
	public String appstatus() {
		return "OK";
	}
	
}

