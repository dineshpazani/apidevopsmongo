package com.apidevops.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apidevops.dao.entitys.User;
import com.apidevops.services.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/user/add")
public class UserController {

	@Autowired
	private UserService userService;
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@RequestBody User userEntity) {    	
        return userService.createUser(userEntity);
    }
    
    @GetMapping
    public Flux<User> findAll() {
        return userService.findAll();
    }
    
    @GetMapping
    @RequestMapping("/user")
    public User findbyusername() {    	
        return userService.findByUser("din");
    }

}
