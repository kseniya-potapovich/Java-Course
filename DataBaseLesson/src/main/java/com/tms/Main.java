package com.tms;

import com.tms.model.User;
import com.tms.repository.UserRepository;

import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        /*User user = new User();
        user.setUsername("Dima");
        user.setUserPassword("poiji");
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setAge(56);

        userRepository.createUser(user);*/

        //userRepository.deleteUser(8L);

        /*User user = new User();
        user.setId(13L);
        user.setUsername("Nikita");
        user.setUserPassword("sapog");
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        user.setChanged(new Timestamp(System.currentTimeMillis()));
        user.setAge(90);
*/
        /*User user = userRepository.findById(13L);
        System.out.println(user);
        user.setUsername("Andrey");
        System.out.println(userRepository.updateUser(user));*/

        List<User> users = userRepository.findAll();
        System.out.println(users);
    }
}
