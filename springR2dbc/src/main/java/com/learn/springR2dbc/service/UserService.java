package com.learn.springR2dbc.service;

import com.learn.springR2dbc.models.Users;
import com.learn.springR2dbc.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public Mono<Users> getUserById(Long id) {
        return userRepo.findById(id);
    }

    public Flux<Users> getUsers() {
        return userRepo.findAll();
    }

    public void  addUser(Users user) {
        userRepo.save(user).subscribe();
    }

    public Mono<Users> updateUser (Users user){
       return userRepo.findById(user.getId())
               .switchIfEmpty(Mono.error(new Exception("User nit found")))
               .map(olderUser -> {
                   if(user.getName()!=null) olderUser.setName(user.getName());
                   return olderUser;
               })
               .flatMap(userRepo::save);
    }


}
