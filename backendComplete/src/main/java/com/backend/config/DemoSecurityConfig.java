package com.backend.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	//add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//add our users for in memory authentication with jdbc auth
		auth.jdbcAuthentication().dataSource(securityDataSource).
		usersByUsernameQuery(
				"select username,password, enabled from credentials where username=?")
			.authoritiesByUsernameQuery(
				"select username, authority from authorities where username=?");;
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/home").permitAll()
			.antMatchers("/").access("hasRole('ROLE_EMPLOYEE')")
			.antMatchers("/").access("hasRole('ROLE_MANAGER')")
			.antMatchers("/").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/cssfiles/**").permitAll()
			//.anyRequest().authenticated() // means that the user must be logged in
			.and()
			.formLogin()
			.loginPage("/showLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}												

	
	
}
