package com.example.demo.User;

import com.example.demo.Admin.Admin;
import com.example.demo.Admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServies {
    private final UserRepository userRepository;
    @Autowired
    public UserServies(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUser(String id) {
        Long user_id= Long.parseLong(id);
//        System.out.println(getUser("1"));
        return userRepository.findById(user_id).orElse(null);
    }
    public User createUser(User user) {
        return  userRepository.save(user);
    }
    public void deleteUser(String id) {
        Long  user_id= Long.parseLong(id);
        userRepository.deleteById(user_id);
    }
    public void updateUser(String id, User data) {
        Long  user_id= Long.parseLong(id);
        User user=userRepository.findById(user_id).orElse(null);
        if (user != null) {
            user.setName(data.getName());
            user.setPasswords(data.getPasswords());
            user.setEmail(data.getEmail());
            user.setPhone(data.getPhone());
            user.setActive(data.isActive());
        }

    }


}

