/*
  *  Company: RS
 *  Project: spring-security-demo
 *  Created: 9 gru 2021  12:19:55
 *  Author:  RS 		
 */
package pl.rsof.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 * <p>Inicjalizacja Spring Security</p><p>9 gru 2021</p>
 * @author RS
 *
 */
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add users for in memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("MANAGER"))
			.withUser(users.username("susan").password("test123").roles("ADMIN"));
		
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests() 				// restrict access based on the HttpServletRequest
		.anyRequest().authenticated()			// any request to the app must be authenticated (logged in)
		.and()
		.formLogin()         					// customizing the form login process
			.loginPage("/showLoginPage")     		// show custom form at the request mapping "/showLoginPage"
			.loginProcessingUrl("/authenticateTheUser")	// login form should POST data to this URL for processing (login and password)
			.permitAll()							// allow everyone to see login page. No need to be logged in
		.and()
		.logout().permitAll();					// logout support for default url '/logout'
	}	
	
}
