package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
	
	@GetMapping("/sayhello")
	//@RequestMapping(method=RequestMethod.GET, value = "/sayhello")
	public String sayHello() {
		return "hello world , I am your first API ..............";
	}
	
	

}
