package com.example.ems.service;

import com.example.ems.dto.UserDto;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.model.User;

public interface UserService {
    User saveUser(UserDto userDto) throws ResourceNotFoundException;
    boolean checkUser(UserDto userDto);
}
