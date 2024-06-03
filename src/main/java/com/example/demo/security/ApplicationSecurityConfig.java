package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
//@EnableWebSecurity
public class ApplicationSecurityConfig {
	
	@Bean
	protected SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		http
//			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(authorizeRequests -> 
				authorizeRequests
					.requestMatchers("/").permitAll()
					.anyRequest()
					.authenticated()
			).formLogin();
		
//		http.httpBasic(withDefaults());
		
		return http.build();
	}
	
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
		
	}
	
	
	@Bean
	protected UserDetailsService userDetailsService () {
		
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("password"))
				.roles("ADMIN")
				.build();
		
		UserDetails user = User.builder()
				.username("user")
				.password(passwordEncoder().encode("password"))
				.roles("USER")
				.build();
		
		
		
		return new InMemoryUserDetailsManager(admin, user);
	}

}
