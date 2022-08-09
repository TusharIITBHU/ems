package com.example.ems.services;

import com.example.ems.models.Users;

public interface UsersService {
    void saveUser(Users user);
    Users getUserByUsername(String username);

}
