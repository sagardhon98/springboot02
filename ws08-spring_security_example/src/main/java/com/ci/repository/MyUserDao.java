package com.ci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ci.model.MyUser;

@Repository
public interface MyUserDao extends JpaRepository<MyUser, Long> {

	MyUser findByUsername(String username);
}
