package com.boot.springboot.security.service;

import com.boot.springboot.exceptions.SameUserInDatabase;
import com.boot.springboot.model.User;
import com.boot.springboot.repository.UserRepository;
import com.boot.springboot.security.model.Roles;
import com.boot.springboot.security.model.UserSecurity;
import com.boot.springboot.security.model.dto.AuthRequestDto;
import com.boot.springboot.security.model.dto.RegistrationUserDto;
import com.boot.springboot.security.repository.UserSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserSecurityService {
    private final PasswordEncoder passwordEncoder;
    private final UserSecurityRepository userSecurityRepository;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    @Autowired
    public UserSecurityService(PasswordEncoder passwordEncoder, UserSecurityRepository userSecurityRepository, UserRepository userRepository, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.userSecurityRepository = userSecurityRepository;
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
    }

    @Transactional(rollbackFor = Exception.class)
    public void registration(RegistrationUserDto registrationUserDto) {
        Optional<UserSecurity> security = userSecurityRepository.findByUserLogin(registrationUserDto.getLogin());
        if (security.isPresent()) {
            throw new SameUserInDatabase(registrationUserDto.getLogin());
        }
        User user = new User();
        user.setUsername(registrationUserDto.getUsername());
        user.setAge(registrationUserDto.getAge());
        user.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        user.setChanged(Timestamp.valueOf(LocalDateTime.now()));
        User savedUser = userRepository.save(user);

        UserSecurity userSecurity = new UserSecurity();
        userSecurity.setUserLogin(registrationUserDto.getLogin());
        userSecurity.setUserPassword(passwordEncoder.encode(registrationUserDto.getPassword()));
        userSecurity.setRole(Roles.USER);
        userSecurity.setUserId(savedUser.getId());
        userSecurity.setIsBlocked(false);
        userSecurityRepository.save(userSecurity);
    }

    public Optional<String> generateToken(AuthRequestDto authRequestDto) {
        Optional<UserSecurity> security = userSecurityRepository.findByUserLogin(authRequestDto.getLogin());
        if (security.isPresent() && passwordEncoder.matches(authRequestDto.getPassword(), security.get().getUserPassword())) {
            return Optional.of(jwtUtils.generateJwtToken(authRequestDto.getLogin()));
        }
        return Optional.empty();
    }
}
