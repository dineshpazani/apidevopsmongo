package com.apidevops.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;

import com.apidevops.repository.UserRepository;

import reactor.core.publisher.Mono;


@EnableWebFluxSecurity
public class SecurityConfig {
	

    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {

        //@formatter:off
        return http
                    .csrf().disable()
                    .httpBasic().securityContextRepository(new WebSessionServerSecurityContextRepository())
                .and()
                    .authorizeExchange()
                    .pathMatchers(HttpMethod.GET, "/posts/**").authenticated()
                    .pathMatchers(HttpMethod.DELETE, "/posts/**").hasRole("ADMIN")
                    .pathMatchers("/posts/**").authenticated()
                    .pathMatchers("/auth/**").authenticated()
                    .pathMatchers("/users/{user}/**").access(this::currentUserMatchesPath)
                    .anyExchange().authenticated()
                .and()
                    .build();
        //@formatter:on
    }

    private Mono<AuthorizationDecision> currentUserMatchesPath(Mono<Authentication> authentication, AuthorizationContext context) {
        return authentication
            .map(a -> context.getVariables().get("user").equals(a.getName()))
            .map(AuthorizationDecision::new);
    }

    /*@Bean
    public ReactiveUserDetailsService userDetailsService(UserRepository users) {
        return (username) -> users.findByUsername(username)
        		.map(u -> User.withUsername(u.getUsername())
                        .password(u.getPassword())
                        .authorities(u.getRoles().toArray(new String[0]))
                        .accountExpired(!u.isActive())
                        .credentialsExpired(!u.isActive())
                        .disabled(!u.isActive())
                        .accountLocked(!u.isActive())
                        .build()
                    );

    }*/
	
	  @Bean
	    public ReactiveUserDetailsService userDetailsService(UserRepository users) {
		  return (username) -> users.findByUsername(username)
		            .map(u -> User.withDefaultPasswordEncoder()
		            		.username(u.getUsername())
		                    .password(u.getPassword())
		                    .authorities(u.getRoles().toArray(new String[0]))
		                    /*.accountExpired(!u.isActive())
		                    .credentialsExpired(!u.isActive())
		                    .disabled(!u.isActive())
		                    .accountLocked(!u.isActive())*/
		                    .build()
		                );
		  
	       /* UserBuilder userBuilder = User.withDefaultPasswordEncoder();
	        UserDetails rob = userBuilder.username("test").password("password").roles("USER").build();
	        UserDetails admin = userBuilder.username("admin").password("password").roles("USER","ADMIN").build();
	        return new MapReactiveUserDetailsService(rob, admin);*/
	    }

}
