package com.backend.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.backend")
@PropertySource("classpath:persistence-mysql.properties")
@EnableTransactionManagement
public class DemoAppConfig implements WebMvcConfigurer {

	//set up variable to hold the properties
	
		@Autowired
		private Environment env;
		
		//set up a logger for diagnostics
		
		private Logger logger=Logger.getLogger(getClass().getName());
		
		@Bean
		public LocalSessionFactoryBean sessionFactory() {
		   LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		   sessionFactory.setDataSource(securityDataSource());
		   sessionFactory.setPackagesToScan(
		       new String[] { "com.backend.entity" }
		   );
		   sessionFactory.setHibernateProperties(hibernateProperties());

		   return sessionFactory;
		}
		
		Properties hibernateProperties() {
		    return new Properties() {
		        {
		            setProperty("hibernate.show_sql", "true");
		            setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		        }
		    };
		}
		
		@Bean
		@Autowired
		public HibernateTransactionManager transactionManager(
		    SessionFactory sessionFactory) {
		    HibernateTransactionManager txManager = new HibernateTransactionManager();
		    txManager.setSessionFactory(sessionFactory);
		    return txManager;
		}
	
	//define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = 
				new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	//define a bean for security datasource
	
	@Bean
	public DataSource securityDataSource() {
		
		//create connection pool
		ComboPooledDataSource securityDataSource = 
				new ComboPooledDataSource();
		
		//set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		}catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
			
		//log the connection properties
		logger.info(">>> jdbc.url="+env.getProperty("jdbc.url"));	
		logger.info(">>> jdbc.user="+env.getProperty("jdbc.user"));
		
		//set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty(
				"connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty(
				"connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty(
				"connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty(
				"connection.pool.maxIdleTime"));
			
		return securityDataSource;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/cssfiles/**")
		.addResourceLocations("/cssfiles/");
	}
	
	private int getIntProperty(String propName) {

		return Integer.parseInt(env.getProperty(propName));
	}
	
	
}
