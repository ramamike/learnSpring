package com.learning.springsecurityregistration.service;

import com.learning.springsecurityregistration.entity.User;
import com.learning.springsecurityregistration.entity.VerificationToken;
import com.learning.springsecurityregistration.model.UserModel;
import com.learning.springsecurityregistration.repository.UserRepository;
import com.learning.springsecurityregistration.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    private PasswordEncoder passwordEncoder;

    private VerificationTokenRepository verificationTokenRepo;

    public User registerUser(UserModel userModel) {
        User user = User.builder()
                .userName(userModel.getUserName())
                .email(userModel.getEmail())
                .role("USER")
                .password(passwordEncoder.encode(userModel.getPassword()))
                .build();
        userRepo.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken =
                new VerificationToken(user, token);
        verificationTokenRepo.save(verificationToken);
    }
}
