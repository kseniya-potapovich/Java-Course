package com.boot.springboot.service;

import com.boot.springboot.model.User;
import com.boot.springboot.model.dto.UserCreateDto;
import com.boot.springboot.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    static User user = new User();

    @BeforeAll
    public static void beforeAll() {
        user.setId(5L);
    }

    @Test
    void getAllUsers_Success() {
        userService.getAllUsers();
        Mockito.verify(userRepository, Mockito.times(1)).customGetAll();
    }

    @Test
    void createUser_Success() {
        Mockito.when(userRepository.save(any())).thenReturn(user);
        userService.createUser(new UserCreateDto());
        Mockito.verify(userRepository, Mockito.times(1)).save(any());
    }

    @Test
    void updateUser_Success() {
        Mockito.when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        userService.updateUser(user);
        Mockito.verify(userRepository, Mockito.times(1)).saveAndFlush(any());
    }

    @Test
    void deleteUser_Success() {
        userService.deleteUser(100L);
        Mockito.verify(userRepository, Mockito.times(1)).deleteById(anyLong());

    }
}
