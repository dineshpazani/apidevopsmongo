/*package com.apidevops.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.apidevops.dao.entitys.User;
import com.apidevops.repository.UserRepository;

@Component
public class MongoUserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userRepository.findByUsername(username);
	    if(userEntity == null) {
	      throw new UsernameNotFoundException("User not found");
	    }
	    return userEntity;
	}
}
*/