package com.ci.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ci.service.MyUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfigUserDetails extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserService myUserService;
	
	@Autowired
	private AppConfig passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserService)
		.passwordEncoder(passwordEncoder.encode());
		
	}

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
