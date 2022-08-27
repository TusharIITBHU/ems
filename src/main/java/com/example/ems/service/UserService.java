package com.example.ems.service;

import com.example.ems.dto.UserDto;
import com.example.ems.model.User;

public interface UserService {
    void saveUser(UserDto userDto);
    User getUserByUsername(String username);

}
