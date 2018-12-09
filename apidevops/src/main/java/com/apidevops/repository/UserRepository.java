package com.apidevops.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.apidevops.dao.entitys.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

	Mono<User> findByUsername(String username);

	Flux<User> findByEmail(String email);

	Mono<User> findByIdAndDeleteIsFalse(String email);

}
