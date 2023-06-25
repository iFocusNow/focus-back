package com.focus.service;

import com.focus.model.Parent;
import com.focus.repository.ParentRepository;
import com.focus.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ParentRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Parent parent = userRepository.findByEmail(email);
        if (parent != null)
            return new SecurityUser(parent);
        else
            throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
