package com.srikantvs.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srikantvs.user.entity.User;
import com.srikantvs.user.service.UserService;
import com.srikantvs.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	// method to save user
	@PostMapping(value = "/")
	public User saveUser(@RequestBody User user) {
		log.info("inside saveUser of UserController");
		return userService.saveUser(user);
	}
	// method to get user based on dept.

	@GetMapping(value = "/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("inside getUserWithDepartment of UserController");
		return userService.getUserWithDepartment(userId);
	}

}
