package com.ci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ci.model.UserDtls;

@Repository
public interface UserDao extends JpaRepository<UserDtls, Long> {

	UserDtls findByUsername(String username);
}
