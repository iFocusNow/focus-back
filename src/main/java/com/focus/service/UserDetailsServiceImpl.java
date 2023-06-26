package com.focus.service;
import com.focus.model.User;
import com.focus.repository.UserRepository;
import com.focus.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRespository.findByUserName(username);
        if (user!=null){
            return new SecurityUser(user);
        }
        throw  new UsernameNotFoundException("User not found: "+username);
    }
}
