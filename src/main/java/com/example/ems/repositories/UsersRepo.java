package com.example.ems.repositories;

import com.example.ems.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepo extends MongoRepository<Users,String> {
}
