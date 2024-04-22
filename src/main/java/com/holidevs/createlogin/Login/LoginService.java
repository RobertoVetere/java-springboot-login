package com.holidevs.createlogin.Login;

import com.holidevs.createlogin.AppUser.AppUser;
import com.holidevs.createlogin.AppUser.AppUserDto;
import com.holidevs.createlogin.AppUser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    AppUserService appUserService;
    public AppUserDto loginUser(AppUser user) {
        Optional<AppUser> userFind =  appUserService.loginUser(user);

        AppUserDto loggedUser = new AppUserDto(
                userFind.get().getName(),
                userFind.get().getUsername(),
                userFind.get().getEmail());

        return loggedUser;
    }

}
