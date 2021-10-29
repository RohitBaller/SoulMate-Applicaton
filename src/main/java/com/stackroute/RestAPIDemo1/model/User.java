package com.stackroute.RestAPIDemo1.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class User {
    private int age;
    @Id
    private String name;
    private String city;
    private String email;
    private String password;





}
