package com.boot.springboot.service;

import com.boot.springboot.model.User;
import com.boot.springboot.model.dto.UserCreateDto;
import com.boot.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.customGetAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return getUserById(id).isEmpty();
    }

    public Boolean createUser(UserCreateDto userFromDto) {
        User user = new User();
        user.setUserPassword(userFromDto.getUserPassword());
        user.setUsername(userFromDto.getUsername());
        user.setAge(userFromDto.getAge());
        user.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        user.setChanged(Timestamp.valueOf(LocalDateTime.now()));
        User newUser = userRepository.save(user);
        return getUserById(newUser.getId()).isPresent();
    }

    public Boolean updateUser(Long id, String username, String userPassword, Integer age) {
        Optional<User> user1 = userRepository.findById(id);
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
            User updateUser = userRepository.saveAndFlush(user2);
            return user2.equals(updateUser);
        }
        return false;
    }
}
