package com.holidevs.createlogin.Registration;

import com.holidevs.createlogin.AppUser.AppUser;
import com.holidevs.createlogin.AppUser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    AppUserService appUserService;
    public AppUser register(AppUser user) {
        return appUserService.createAppUser(user);
    }
}
