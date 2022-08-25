package com.example.ems.security;

import com.example.ems.model.User;
import com.example.ems.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userRepo.findById(username).orElse(null);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }

        return new UserDetailsImpl(user);
    }
}
