package com.ssafy.traveen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Traveen")
public class MainController {
	@GetMapping("/test")
	public String index() {
		return "hello";
	}
}