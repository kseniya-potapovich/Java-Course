package com.boot.springboot.security.service;

import com.boot.springboot.security.repository.UserSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService {
    public final UserSecurityRepository userSecurityRepository;

    @Autowired
    public UserSecurityService(UserSecurityRepository userSecurityRepository) {
        this.userSecurityRepository = userSecurityRepository;
    }
}
