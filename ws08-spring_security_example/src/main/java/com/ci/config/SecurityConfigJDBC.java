package com.ci.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfigJDBC extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AppConfig passwordEncoder;

	/**
	 * Authentication
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/**
		 * In-memory credential
		 * */
//		auth.inMemoryAuthentication().withUser("sagar").password("sagar").authorities("ADMIN");
//		auth.inMemoryAuthentication().withUser("Ram").password("ram").authorities("MANAGER");
//		auth.inMemoryAuthentication().withUser("Sham").password("sham").authorities("DEVELOPER");

		/**
		 * JDBC
		 * */
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username , password, enabled from user_details where username=?")
		.authoritiesByUsernameQuery("select username , role from user_details where username=?")
		.passwordEncoder(passwordEncoder.encode());
	}

	/**
	 * Autorization
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/admin").hasAuthority("Admin")
		.antMatchers("/developer").hasAuthority("Developer")
		.antMatchers("/manager").hasAuthority("Manager")
		.antMatchers("/common").hasAnyAuthority("Admin", "Manager")
		.anyRequest().authenticated()
		.and().formLogin()
		.and().exceptionHandling().accessDeniedPage("/accessDenied");
	}
}
