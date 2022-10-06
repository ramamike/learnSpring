package com.learn.springR2dbc.repository;

import com.learn.springR2dbc.models.Users;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ReactiveCrudRepository<Users, Long> {
}
