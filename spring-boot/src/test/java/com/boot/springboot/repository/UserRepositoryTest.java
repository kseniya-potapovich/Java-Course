package com.boot.springboot.repository;

import com.boot.springboot.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    static User user;

    @BeforeAll
    static void beforeAll() {
        user = new User();
        user.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        user.setChanged(Timestamp.valueOf(LocalDateTime.now()));
        user.setUsername("testName");
    }

    @Test
    void findAllTest_Success() {
        List<User> users = userRepository.findAll();
        Assertions.assertNotNull(users);
    }

    @Test
    void findByIdTest_Success() {
        User userFromDB = userRepository.findAll().get(0);
        Optional<User> user = userRepository.findById(userFromDB.getId());
        Assertions.assertTrue(user.isPresent());
    }

    @Test
    void saveTest_success() {
        User savedUser = userRepository.save(user);
        Optional<User> user = userRepository.findById(savedUser.getId());
        Assertions.assertTrue(user.isPresent());
    }

    @Test
    void updateTest_Success(){
        User savedUser = userRepository.save(user);
        savedUser.setUsername("newNameTest");
        User resultUser = userRepository.saveAndFlush(savedUser);
        Assertions.assertEquals(resultUser.getUsername(), "newNameTest");
    }

    @Test
    void deleteTest_Success(){
        User savedUser = userRepository.save(user);
        userRepository.deleteById(savedUser.getId());
        Optional<User> resultUser = userRepository.findById(savedUser.getId());
        Assertions.assertFalse(resultUser.isPresent());
    }
}
