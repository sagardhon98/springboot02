package com.ci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ci.model.MyUser;
import com.ci.repository.MyUserDao;

@Service
public class MyUserService implements UserDetailsService {

	@Autowired
	private MyUserDao myUserDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser findByUsername = myUserDao.findByUsername(username);

		if (findByUsername == null) {
			throw new UsernameNotFoundException("User not available.");
		}

		UserDetails userDetails = User
				.withUsername(findByUsername.getUsername())
				.password(findByUsername.getPassword())
				.disabled(findByUsername.isActive())
				.authorities(findByUsername.getRole())
				.build();
		return userDetails;
	}

}
