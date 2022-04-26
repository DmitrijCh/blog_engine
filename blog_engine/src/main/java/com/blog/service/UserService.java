package com.blog.service;

import com.blog.api.UserPrincipal;
import com.blog.model.Users;
import com.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Users users = userRepository.findByEmail(email);
        System.out.println(users);
        if (users == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserPrincipal(users);
    }
}
