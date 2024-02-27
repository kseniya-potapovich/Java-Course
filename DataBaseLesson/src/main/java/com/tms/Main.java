package com.tms;

import com.tms.model.User;
import com.tms.repository.UserRepository;

import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        System.out.println(userRepository.findById(13L));
    }
}
