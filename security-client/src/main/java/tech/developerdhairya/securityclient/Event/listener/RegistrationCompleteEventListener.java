package tech.developerdhairya.securityclient.Event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import tech.developerdhairya.securityclient.Entity.UserEntity;
import tech.developerdhairya.securityclient.Event.RegistrationCompleteEvent;
import tech.developerdhairya.securityclient.Service.UserService;
import tech.developerdhairya.securityclient.Service.UserServiceImpl;

import java.util.UUID;

@Slf4j @Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {

        UserEntity userEntity=event.getUserEntity();
        String token= UUID.randomUUID().toString();
        userService.saveUserVerfificationToken(token,userEntity);
        //send mail to user
        String url=event.getApplicationUrl()+"verifyRegistration?token="+token;
        log.info("Click here to verify your account "+url);

    }
}
