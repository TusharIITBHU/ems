package com.example.ems.service;

import com.example.ems.dto.UserDto;
import com.example.ems.exception.ResourceNotFoundException;

public interface UserService {
    void saveUser(UserDto userDto) throws ResourceNotFoundException;
}
