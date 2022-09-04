package com.example.ems.service;

import com.example.ems.dto.UserDto;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.model.User;
import com.example.ems.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userServiceImpl;

    @MockBean
    UserRepo userRepo;

    User expectedUser = new User("tush", "tush");
    User actualUser = new User("tush", "tush");

    @Test
    void saveUserSuccess() {
        UserDto userDto = new UserDto("tush", "tush");
        when(userRepo.save(actualUser)).thenReturn(actualUser);
        try {
            assertThat(expectedUser.equals(userServiceImpl.saveUser(userDto)));
        } catch (ResourceNotFoundException e) {
            assertThat(e.getMessage());
        }
    }

    @Test
    public void saveUserFailureOne() {
        UserDto userDto = new UserDto("", "tush");
        when(userRepo.save(actualUser)).thenReturn(actualUser);
        try {
            userServiceImpl.saveUser(userDto);
            fail();
        } catch (ResourceNotFoundException e) {
            assertThat(e.getMessage());
        }
    }

    @Test
    public void saveUserFailureTwoTest() {
        String id = "green";
        UserDto userDto = new UserDto(id, "222");
        when(userRepo.findById(id)).thenReturn(Optional.ofNullable(actualUser));
        when(userRepo.save(actualUser)).thenReturn(actualUser);
        try {
            if (expectedUser.equals(actualUser)) {
                fail();
            }
            userServiceImpl.saveUser(userDto);
        } catch (ResourceNotFoundException e) {
            assertThat(e.getMessage());
        }
    }
}