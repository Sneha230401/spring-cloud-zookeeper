package com.baeldung.spring.cloud.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class provides operations on the Validation service.
 *
 * <p>
 * When booting up, Spring will try and find a service named "Validation" (see
 * the FeignClient below) under the available ZooKeeper instance.
 * </p>
 *
 */
@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class RegistrationClient {
	@Autowired
	private RegistrationClientI registrationClient;

	@FeignClient(name = "UserManagement")
	interface RegistrationClientI {

		@RequestMapping(path = "/register", method = RequestMethod.GET)
		@ResponseBody
		String register();

		@RequestMapping(path = "/login", method = RequestMethod.GET)
		@ResponseBody
		String login();


		@RequestMapping(value = "/process_register", method = RequestMethod.GET)
		@ResponseBody
		public String processRegister(String firstName);

	}


	public String register() {
		return registrationClient.register();
		//return "Hello World";
	}

	public String login() {
		return registrationClient.login();
		//return "Hello World";
	}

	public String processRegister(String firstName) {
		return registrationClient.processRegister(firstName);
		//return "Hello World";
	}

}
