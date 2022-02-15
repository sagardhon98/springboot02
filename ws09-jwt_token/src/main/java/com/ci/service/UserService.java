package com.ci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ci.model.UserDtls;
import com.ci.repository.UserDao;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDtls userDtls = userDao.findByUsername(username);
		
		UserDetails userDetails = User
		.withUsername(userDtls.getUsername())
		.password(userDtls.getPassword())
		.authorities(userDtls.getRole()) 
		.build();
		
		return userDetails;
	}

}
