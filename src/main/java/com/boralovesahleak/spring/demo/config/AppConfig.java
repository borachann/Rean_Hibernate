/**
 * 
 */
package com.boralovesahleak.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * this is for ah leak configuration
 * hahahah
 * For resource handler,
 * additonal configuration   --> content mapper
 * OK? ok
 * @author channbora loves ah leak
 *
 */
@Configuration

public class AppConfig  extends WebMvcConfigurerAdapter{

	// here is custom view resolver --< you can use any other template
	@Bean
	public InternalResourceViewResolver jspViewResolver(){
		InternalResourceViewResolver v = new InternalResourceViewResolver();
		v.setPrefix("/WEB-INF/loves/"); // so change to /WEB-INFO/loves   all view will be /WEB-INFO/loves/ OK??
		v.setSuffix("_view.jsp");
		return v;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry reg){
		InternalResourceViewResolver resolver= jspViewResolver();
		reg.viewResolver(resolver);
	}
	
/*	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		return viewResolver();
	}*/
/*	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}*/
}
// yii see my question?where team viewer