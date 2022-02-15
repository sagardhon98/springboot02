package com.ci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ws08SpringSecurityExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ws08SpringSecurityExampleApplication.class, args);
		
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		String encode = bCryptPasswordEncoder.encode("Sid100");
//		System.out.println("Encode Password : " + encode);
		
	}

}
