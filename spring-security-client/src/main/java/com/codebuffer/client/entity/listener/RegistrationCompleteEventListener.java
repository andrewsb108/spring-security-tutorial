package com.codebuffer.client.entity.listener;

import com.codebuffer.client.entity.User;
import com.codebuffer.client.event.RegistrationCompleteEvent;
import com.codebuffer.client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the Verification Token for the User
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);

        //Send Mail to user
        String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;
        //sendVerificationEmail() -> could be there
        log.info("Click the link to verify your account: {}", url);
    }
}
