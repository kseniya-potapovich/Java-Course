package com.boot.springboot.service;

import com.boot.springboot.aop.TimeAOP;
import com.boot.springboot.model.User;
import com.boot.springboot.model.dto.UserCreateDto;
import com.boot.springboot.repository.UserRepository;
import com.boot.springboot.security.model.UserSecurity;
import com.boot.springboot.security.repository.UserSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserSecurityRepository userSecurityRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserSecurityRepository userSecurityRepository) {
        this.userRepository = userRepository;
        this.userSecurityRepository = userSecurityRepository;
    }

    @TimeAOP
    public List<User> getAllUsers() {
        return userRepository.customGetAll();
    }

    @TimeAOP
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return getUserById(id).isEmpty();
    }

    public Boolean createUser(UserCreateDto userFromDto) {
        User user = new User();
        user.setUsername(userFromDto.getUsername());
        user.setAge(userFromDto.getAge());
        user.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        user.setChanged(Timestamp.valueOf(LocalDateTime.now()));
        User newUser = userRepository.save(user);
        return getUserById(newUser.getId()).isPresent();
    }

    public Boolean updateUser(User user) {
        Optional<User> user1 = userRepository.findById(user.getId());
        if (user1.isPresent()) {
            User user2 = user1.get();
            if (user.getUsername() != null) {
                user2.setUsername(user.getUsername());
            }
            if (user.getAge() != null) {
                user2.setAge(user.getAge());
            }
            user2.setChanged(Timestamp.valueOf(LocalDateTime.now()));
            User updateUser = userRepository.saveAndFlush(user2);
            return user2.equals(updateUser);
        }
        return false;
    }

    public List<User> getUsersAndSortByField(String field) {
        return userRepository.findAll(Sort.by(field));
    }

    public List<User> getUsersWithPagination(int size, int page) {
        return userRepository.findAll(Pageable.ofSize(size).withPage(page)).getContent();
    }

    public Optional<User> getInfoAboutCurrentUser(String username) {
        Optional<UserSecurity> userSecurityOptional = userSecurityRepository.findByUserLogin(username);
        if (userSecurityOptional.isEmpty()) {
            return Optional.empty();
        }
        return userRepository.findById(userSecurityOptional.get().getUserId());
    }
}
