/*
 *  Company: RS
 *  Project: spring-security-demo
 *  Created: 7 gru 2021  13:21:08
 *  Author:  RS 		
 */
package pl.rsof.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * <p>Konfiguracja dispachera, bez XML</p><p>7 gru 2021</p>
 * @author RS
 *
 */
public class MySpringMvcDispacherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// no root config classes for project, only servlet config classes	
		return null;
	}

	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// only servlet config class (created earlier)
		return new Class[] {DemoAppConfig.class};
	}

	
	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};
	}

}
