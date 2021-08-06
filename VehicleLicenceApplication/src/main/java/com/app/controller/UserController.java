package com.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.UserService;

@RestController
@RequestMapping("User")
public class UserController {

	UserService service;
}
