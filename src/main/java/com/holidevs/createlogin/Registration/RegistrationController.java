package com.holidevs.createlogin.Registration;

import com.holidevs.createlogin.AppUser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @Autowired
    AppUser user;

    public String register(@RequestBody AppUser user){
        return registrationService.register(user);
    }

}
