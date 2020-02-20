package com.marshal.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// mark this class as a RESTful Controller using annotation
@RestController
public class HelloWorldController {
	
	@GetMapping(path="/hello-world")
	public String printMessage() {
		return "Hello World";
	}
	
	@GetMapping(path="/helloworld_bean")
	public HelloWorldBean printMessageFromBean() {
		return new HelloWorldBean("Hello World!");
	}
	
	@GetMapping(path="/helloworld/pathvariable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

}
