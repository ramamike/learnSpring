package com.learning.springsecurityregistration.event.listener;

import com.learning.springsecurityregistration.entity.User;
import com.learning.springsecurityregistration.event.RegistrationCompleateEvent;
import com.learning.springsecurityregistration.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener
        implements ApplicationListener<RegistrationCompleateEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleateEvent event) {
        //Create the Verification token for the user with Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        //Send mail to sender
        String url = event.getApplicationUrl() +
                "verifyRegistration?token=" + token;

        //SendVerificationEmail()
        log.info("Click the link to verify your account: {}", url);
    }
}
