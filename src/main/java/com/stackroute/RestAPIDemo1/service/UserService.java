package com.stackroute.RestAPIDemo1.service;

import com.stackroute.RestAPIDemo1.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
    boolean deleteByName(String name);
    User updateUser(User user , String name);
}
