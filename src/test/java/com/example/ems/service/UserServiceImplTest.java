package com.example.ems.service;

import com.example.ems.dto.UserDto;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.model.User;
import com.example.ems.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
            assertThat(expectedUser.equals(userServiceImpl.saveUser(userDto))).isEqualTo(true);
        } catch (ResourceNotFoundException e) {
            assertThat(e.getErrorDto().getMessage());
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
            assertThat(e.getErrorDto().getMessage());
        }
    }

    @Test
    public void saveUserFailureTwoTest() {//nw
        String id = "tush";
        UserDto userDto = new UserDto(id, "tush");
        when(userRepo.existsById(id)).thenReturn(true);
        when(userRepo.save(actualUser)).thenReturn(actualUser);
        try {
            if (expectedUser.equals(userServiceImpl.saveUser(userDto))) {
                fail();
            }
        } catch (ResourceNotFoundException e) {
            System.out.println("ok");
            assertThat(e.getErrorDto().getMessage());
        }
    }
}