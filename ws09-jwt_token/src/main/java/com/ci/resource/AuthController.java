package com.ci.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ci.dto.AuthRequest;
import com.ci.dto.AuthResponse;
import com.ci.util.JwtUtil;

@RestController
public class AuthController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	UserDetailsService userDetailsService;
	
//	@Autowired
//	private AuthenticationManager authenticationManager;
		
	
		
	
	@PostMapping("/token")
	public AuthResponse generateToken(@RequestBody AuthRequest authRequest) {
		
		//TODO : Check username and password.
		//if username and password available then generate token else throw bad credentials.
		
		UserDetails loadUserByUsername = userDetailsService.loadUserByUsername(authRequest.getUsername());
		if(loadUserByUsername == null) {
			throw new UsernameNotFoundException("User not available.");
		}
		
		String generateJwtToken = jwtUtil.generateJwtToken(authRequest.getUsername());	
		AuthResponse authResponse = new AuthResponse();
		authResponse.setToken(generateJwtToken);
		
		return authResponse;
	}
}
