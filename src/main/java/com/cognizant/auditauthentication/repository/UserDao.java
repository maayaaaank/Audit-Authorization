package com.cognizant.auditauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.auditauthentication.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	User findByUserName(String userName);
}