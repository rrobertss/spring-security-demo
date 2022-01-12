/*
  *  Company: RS
 *  Project: spring-security-demo
 *  Created: 9 gru 2021  12:19:55
 *  Author:  RS 		
 */
package pl.rsof.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	
	// reference to dataSource
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// user jdbc authentication
		auth.jdbcAuthentication().dataSource(dataSource);
		
		
		
		// add users for in memory authentication, bez MySQL
	/*	UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
			.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));*/
		
	}

	// bez ról, wystarczy sie zalogować
	/*
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
	}*/
	
	
	// obsluga ról
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests() 				// restrict access based on the HttpServletRequest
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and()
		.formLogin()         					// customizing the form login process
			.loginPage("/showLoginPage")     		// show custom form at the request mapping "/showLoginPage"
			.loginProcessingUrl("/authenticateTheUser")	// login form should POST data to this URL for processing (login and password)
			.permitAll()							// allow everyone to see login page. No need to be logged in
		.and()
		.logout().permitAll()					// logout support for default url '/logout'
		.and()
		.exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
}
