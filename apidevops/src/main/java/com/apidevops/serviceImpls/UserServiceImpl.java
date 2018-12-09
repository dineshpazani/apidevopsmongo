package com.apidevops.serviceImpls;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apidevops.dao.entitys.User;
import com.apidevops.repository.UserRepository;
import com.apidevops.services.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Mono<User> createUser(User userEntity) {
		return userRepository.insert(userEntity);
	}

	@Override
	public Flux<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Mono<User> updateUser(User userEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}
