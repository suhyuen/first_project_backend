package com.example.community1.authentication;

import com.example.community1.mappers.UserMapper;
import com.example.community1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    public CustomUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userMapper.userLogin(username);
        return new CustomUserDetails(user.get());
    }
}
