/**
 * 
 */
package com.boralovesahleak.spring.demo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Spring Web Initializer --> 
 * @author channbora
 *
 */
public class WebInit implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		AnnotationConfigWebApplicationContext rootCotext =new AnnotationConfigWebApplicationContext();
		rootCotext.register( MyConfiguraiton.class);// create new annotaion class, configuration class
		ctx.addListener(new ContextLoaderListener(rootCotext));
		
		// wait
		
		// create servlet dispatcher 
		AnnotationConfigWebApplicationContext dispatcherServlet =  new AnnotationConfigWebApplicationContext();
		
		dispatcherServlet.register(AppConfig.class);
		ServletRegistration.Dynamic disatcher = ctx.addServlet("disathcer", new DispatcherServlet(dispatcherServlet));
		disatcher.setLoadOnStartup(1);
		disatcher.addMapping("/");
		System.out.println("WebInit :: onStart");
		
	}

}
