package com.learn.SpringSecurity.repository;

import com.learn.SpringSecurity.entity.User;
import com.learn.SpringSecurity.model.Role;
import com.learn.SpringSecurity.model.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;

    @Test
    public void addUser(){

        List<User> users=List.of(
                User.builder()
                        .email("admin@email.com")
                        .firstName("adminName")
                        .lastName("adminLastName")
                        .role(Role.ADMIN)
                        .password("$2a$12$hV7f1tPba0A27QeoczxkFuYaVW9PtVJTrN8UifPGIqpxdxeKPAwaa")
                        .status(Status.ACTIVE)
                        .build(),
                User.builder()
                        .email("user@email.com")
                        .firstName("userName")
                        .lastName("userLastName")
                        .role(Role.USER)
                        .password("$2a$12$k12hJc75qBfAxZIczDgDE.OYrYiqjLsOETOdZKTDGeTbgxj0LEEgK")
                        .status(Status.BANNED)
                        .build()
        );

        userRepo.saveAll(users);

    }

}