package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ApiController {

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	@ResponseBody
	public String helloWorld(){
		return "Hello World!";
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Object json(){
		return new Domain();
	}
	
	@RequestMapping(value = "/xml", method = RequestMethod.GET, produces="application/xml")
	@ResponseBody
	public Object xml(){
		return new Domain();
	}		
}
