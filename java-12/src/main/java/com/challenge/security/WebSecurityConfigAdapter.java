package com.challenge.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.challenge.dto.UserDTO;
import com.challenge.entity.User;
import com.challenge.repository.UserRepository;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter{
	@Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManagerBean();
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository)
            throws Exception {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setEmail("admin@admin.com");
            user.setPassword("admin123");
            user.setNickname("admin");
            user.setFullName("admin");
            userRepository.save(user);
        }

        builder.userDetailsService(email -> new UserDTO(userRepository.findByEmail(email)));
    }
    
	@Bean  
    public static NoOpPasswordEncoder passwordEncoder() {
    	 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
