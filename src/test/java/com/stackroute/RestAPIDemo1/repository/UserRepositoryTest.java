package com.stackroute.RestAPIDemo1.repository;

import com.stackroute.RestAPIDemo1.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    private User user;
    @BeforeEach
    void setUp(){
        user = new User();
        user.setName("Rohit");
        user.setAge(22);
        user.setCity("Meerut");
        user.setEmail("abc@gmail.com");
        user.setPassword("123");

    }
    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
        user=null;
    }

    @Test
    public void givenUserToSaveShouldReturnSavedUser() {

        User user = new User(22,"Rohit","Meerut","xyz@gmail.com","1234");
        userRepository.save(user);
        User user1=userRepository.findById(user.getName()).get();
        assertNotNull(user1);
        assertEquals(user1.getName(),user1.getName());
    }

    @Test
    public void givenGetAllUserThenShouldReturnListOfAllUsers(){
        User user = new User(22,"Rohit","Meerut","abc@mail","2313");
        User user1 = new User (23,"Rahul","Meerut","ada@mail","232");
        userRepository.save(user);
        userRepository.save(user1);

        List<User> userList = (List<User>) userRepository.findAll();
        assertEquals("Rahul", userList.get(1).getName());
    }
    @Test
    public void givenEmailThenShouldReturnRespectiveUser() {
        User user = new User(22, "Rohit", "Meerut", "abc@gmail.com", "123");
        User user1 = userRepository.save(user);
        Optional<User> optional = userRepository.findById(user1.getName());
        assertEquals(user1.getAge(), optional.get().getAge());
        assertEquals(user1.getCity(), optional.get().getCity());
        assertEquals(user1.getEmail(), optional.get().getEmail());
        assertEquals(user1.getPassword(), optional.get().getPassword());
    }
    @Test
    public void givenEmailToDeleteThenShouldReturnDeleteUser(){
        User user= new User(23,"Rahul","Meerut","xyz@gmail.com","789");
        userRepository.save(user);
        userRepository.deleteById(user.getName());
        Optional optional=userRepository.findById(user.getName());
        assertEquals(Optional.empty(),optional);

    }



}