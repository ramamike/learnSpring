package com.learning.springsecurityregistration.controller;

import com.learning.springsecurityregistration.entity.User;
import com.learning.springsecurityregistration.event.RegistrationCompleateEvent;
import com.learning.springsecurityregistration.model.UserModel;
import com.learning.springsecurityregistration.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private UserService userService;
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel,
                               final HttpServletRequest request) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleateEvent(
                user,
                applicationUrl(request)
        ));
        return "success";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort()+
                request.getContextPath();
    }
}
