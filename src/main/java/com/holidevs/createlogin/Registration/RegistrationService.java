package com.holidevs.createlogin.Registration;

import com.holidevs.createlogin.AppUser.AppUser;
import com.holidevs.createlogin.AppUser.AppUserRole;
import com.holidevs.createlogin.AppUser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    AppUserService appUserService;
    public AppUser registerUser(AppUser user) {
        AppUser newUser = new AppUser(
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                AppUserRole.USER);
        return appUserService.createAppUser(newUser);
    }

    public AppUser registerAdmin(AppUser user) {
        return appUserService.createAppUser(user);
    }
}
