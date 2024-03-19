package com.spring.service;

import com.spring.model.User;
import com.spring.model.dto.UserCreateDto;
import com.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private User user;

    @Autowired
    public UserService(UserRepository userRepository, User user) {
        this.userRepository = userRepository;
        this.user = user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userRepository.findById(id));
    }

    public Boolean deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }

    public Boolean createUser(UserCreateDto userFromDto) {
        user.setUserPassword(userFromDto.getUserPassword());
        user.setUsername(userFromDto.getUsername());
        user.setAge(userFromDto.getAge());
        user.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        user.setChanged(Timestamp.valueOf(LocalDateTime.now()));
        return userRepository.createUser(user);
    }

    public Boolean updateUser(Long id, String username, String userPassword, Integer age) {
        Optional<User> user1 = Optional.ofNullable(userRepository.findById(id));
        if (user1.isPresent()) {
            User user2 = user1.get();
            if (username != null) {
                user2.setUsername(username);
            }
            if (userPassword != null) {
                user2.setUserPassword(userPassword);
            }
            if (age != null) {
                user2.setAge(age);
            }
            user2.setChanged(Timestamp.valueOf(LocalDateTime.now()));
            return userRepository.updateUser(user2);
        }
        return false;
    }
}
