package com.example.ems.services;

import com.example.ems.models.Users;
import com.example.ems.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepo usersRepo;
    @Override
    public void saveUser(Users user) {
        usersRepo.save(user);
    }

    @Override
    public Users getUserByUsername(String username) {
        Users user= usersRepo.findById(username).orElse(null);
        return user;
    }
}
