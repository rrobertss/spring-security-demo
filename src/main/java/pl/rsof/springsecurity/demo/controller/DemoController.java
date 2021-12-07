/*
 *  Company: RS
 *  Project: spring-security-demo
 *  Created: 7 gru 2021  14:01:27
 *  Author:  RS 		
 */
package pl.rsof.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p></p><p>7 gru 2021</p>
 * @author RS
 *
 */
@Controller
public class DemoController {

	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
}
