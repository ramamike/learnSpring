package com.learning.springsecurityregistration.service;

import com.learning.springsecurityregistration.entity.User;
import com.learning.springsecurityregistration.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
