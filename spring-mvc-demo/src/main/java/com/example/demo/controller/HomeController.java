package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String sayHello()
	{
		return "index";
	}
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "showForm";
	}

}
