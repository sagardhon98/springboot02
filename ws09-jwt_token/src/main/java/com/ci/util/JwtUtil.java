package com.ci.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private static final String SECRET_KEY = "Mumbai@123";

	public String generateJwtToken(String subject) {
		String token = Jwts.builder()
		.setId("Token101")
		.setSubject(subject)
		.setIssuer("Sagar")
		.setAudience("Sid")
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMinutes(10)))
		.signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encode(SECRET_KEY.getBytes()))
		.compact();

		return token;
	}
}
