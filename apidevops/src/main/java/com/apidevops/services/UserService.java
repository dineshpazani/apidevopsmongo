package com.apidevops.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.apidevops.dao.entitys.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

	Mono<User> createUser(User userEntity);

	Flux<User> findAll();

	Mono<User> updateUser(User userEntity);

	User findByUser(String username);

	
	User loadUserByUsername(String username) throws UsernameNotFoundException;
}
