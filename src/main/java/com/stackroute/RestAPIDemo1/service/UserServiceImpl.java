package com.stackroute.RestAPIDemo1.service;

import com.stackroute.RestAPIDemo1.model.User;
import com.stackroute.RestAPIDemo1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository= userRepository;
    }


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public boolean deleteByName(String name) {
        if(userRepository.findById(name).isEmpty()){
            return false;
        }
        userRepository.deleteById(name);
        return true;
    }

    @Override
    public User updateUser(User user, String name) {
        if (userRepository.findById(name).isEmpty()){
            return null;
        }
        return userRepository.save(user);
    }
}
