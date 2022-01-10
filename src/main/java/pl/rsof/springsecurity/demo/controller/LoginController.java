/*
 *  Company: RS
 *  Project: spring-security-demo
 *  Created: 9 gru 2021  21:22:14
 *  Author:  RS 		
 */
package pl.rsof.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Proces logowania</p><p>9 gru 2021</p>
 * @author RS
 *
 */
@Controller
public class LoginController {

	
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		// strona logowania bez css
//		return "plain-login";
		
		// strona logowania z bootstrapem
		return "fancy-login";
	}
	

	// request mapping for /accessDenied
	@GetMapping("/accessDenied")
	public String accessDeniedPage() {

		return "access-denied";
	}
	
}
