/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baeldung.spring.cloud.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	private HelloWorldClient helloWorldClient;

	@Autowired
	private RegistrationClient registrationClient;

	@GetMapping("/helloworld")
	public String helloworld() {

		return helloWorldClient.HelloWorld();

	}

	@GetMapping("/register")
	public String register() {

		return registrationClient.register();

	}

	@GetMapping("/login")
	public String login() {

		return registrationClient.login();

	}

	@GetMapping("/process_register/{firstName}")
	public String processRegister(@PathVariable("firstName") String firstName) {
		System.out.println("Sneha is the best");

		return registrationClient.processRegister(firstName);

	}
}
