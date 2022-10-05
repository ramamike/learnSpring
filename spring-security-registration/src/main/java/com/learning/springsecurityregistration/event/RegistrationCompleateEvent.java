package com.learning.springsecurityregistration.event;

import com.learning.springsecurityregistration.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleateEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl;

    public RegistrationCompleateEvent(User user, String applicationUrl) {
        super(user);
        this.user=user;
        this.applicationUrl=applicationUrl;
    }
}
