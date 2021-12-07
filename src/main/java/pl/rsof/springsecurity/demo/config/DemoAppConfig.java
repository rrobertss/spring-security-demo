/*
 *  Company: RS
 *  Project: spring-security-demo
 *  Created: 7 gru 2021  13:12:32
 *  Author:  RS 		
 */
package pl.rsof.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * <p>Konfiguracja aplikacji przez Jave i adnotacje, brak XML-a</p><p>7 gru 2021</p>
 * @author RS
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.rsof.springsecurity.demo")
public class DemoAppConfig {

	
	// define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	 
	
	
}
