package com.example.ems.service;

import com.example.ems.model.User;

public interface UserService {
    void saveUser(User user);
    User getUserByUsername(String username);

}
