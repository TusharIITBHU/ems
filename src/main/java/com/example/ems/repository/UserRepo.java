package com.example.ems.repository;

import com.example.ems.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface UserRepo extends MongoRepository<User,String> {
}
