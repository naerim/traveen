package com.ssafy.users.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.users.model.service.UsersService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/users")
@Api(value="SSAFY")
public class UsersController {
	private UsersService usersService;

	public UsersController(UsersService usersService) {
		super();
		this.usersService = usersService;
	}
	
	@GetMapping("/login")
	public String login() {
		return "users/login";
	}
	
	@PostMapping("/login")
	public String login(Model model, HttpSession session) {
		return "redirect:/";
	}
}
