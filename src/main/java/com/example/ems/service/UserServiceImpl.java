package com.example.ems.service;

import com.example.ems.dto.ErrorDto;
import com.example.ems.dto.UserDto;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.model.User;
import com.example.ems.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Override
    public User saveUser(UserDto userDto) throws ResourceNotFoundException {
        if (userDto.getUsername().isEmpty() || userDto.getPassword().isEmpty()) {
            throw new ResourceNotFoundException(new ErrorDto("INVALID_CREDENTIALS", "Type in correct username and password"));
        } else if (userRepo.existsById(userDto.getUsername())) {
            throw new ResourceNotFoundException(new ErrorDto("USER_ALREADY_EXIST", "try loging in!"));
        }
        User user = new User(userDto.getUsername(), userDto.getPassword());
        userRepo.save(user);
        return user;
    }

    @Override
    public boolean checkUser(UserDto userDto) {
        if ((userRepo.existsById(userDto.getUsername())) && (userDto.getPassword().equals((userRepo.findById(userDto.getUsername())).get().getPassword()))) {
            return true;
        }
        return false;
    }
}
