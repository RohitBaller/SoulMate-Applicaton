package com.stackroute.RestAPIDemo1.controller;

import com.stackroute.RestAPIDemo1.model.User;
import com.stackroute.RestAPIDemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private UserService userService;

@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
@PostMapping("/user")
    public ResponseEntity<User> saveUser (@RequestBody User user){
       User savedUser = userService.saveUser(user);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
       return new ResponseEntity<List<User>>((List<User>) userService.getAllUsers(),HttpStatus.OK);
    }
    @DeleteMapping("/user/{name}")
    public ResponseEntity<?> deleteUser (@PathVariable String name)
    {
        return new ResponseEntity<>(userService.deleteByName(name),HttpStatus.OK);
    }
    @PutMapping("/user/{name}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String name){
    return new ResponseEntity<>(userService.updateUser(user,name),HttpStatus.OK);
    }
}
