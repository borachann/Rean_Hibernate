/**
 * 
 */
package com.boralovesahleak.spring.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.boralovesahleak.spring.dao.StudentDao;
import com.boralovesahleak.spring.dao.impl.StudentDaoImpl;
import com.boralovesahleak.spring.service.StudentService;
import com.boralovesahleak.spring.service.impl.StudentServiceImpl;

/**
 * This is for db, bean configuration
 * @author channbora
 *
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.boralovesahleak.spring")
public class MyConfiguraiton {

	@Autowired
	private Environment env; // spring environment
	/**
	 * when you use environment, you have to create application.properties file in resource folder
	 * now let set fix in code
	 */
	
	
	// now crreate bean  --> go go 
	// crate your own bean here -- I'be back soon ( ot jes te) come here soon
	
	// crate datasource bean
	@Bean
	public DataSource datasource (){
		
		//DriverManagerDataSource ds = new DriverManagerDataSource();
		
		/*ds.setDriverClassName(""); // add value (jam tic tov wc sin) let go on/ set value tov
		ds.setUsername("");
		ds.setPassword("");
		ds.setUrl("");*/
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/My_Server");
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		return dataSource;
	}
	
	// create confiuguration for that transactionmanager
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager (SessionFactory s){
		
		HibernateTransactionManager t = new HibernateTransactionManager(s);
		return t;
	}
	
	@Bean
	public Properties hibernatteProperties(){
		Properties properties = new Properties();
		//properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect"); // this should be postgres, not MySQL
		properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.format_sql","true");
	    properties.put("hibernate.hbm2ddl.auto", "update"); //how to creata auto?
	    return properties;
	}
@Bean
public LocalSessionFactoryBean sessionFactory(){
	LocalSessionFactoryBean s = new LocalSessionFactoryBean();
	s.setDataSource(datasource());
	s.setPackagesToScan("com.boralovesahleak.spring.demo.model");
	s.setHibernateProperties(hibernatteProperties());
	
	return s;
}


/*@Bean
public StudentService studentService(){ 
	return new StudentServiceImpl(); 
}
@Bean 
public StudentDao studentDao(){ 
	return new StudentDaoImpl();
	
	}*/
}
