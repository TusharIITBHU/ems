package com.example.ems.service;

import com.example.ems.dto.UserDto;
import com.example.ems.model.User;
import com.example.ems.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Override
    public void saveUser(UserDto userDto) {
        User user=new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userRepo.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        User user= userRepo.findById(username).orElse(null);
        return user;
    }
}
