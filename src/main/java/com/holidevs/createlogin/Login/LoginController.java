package com.holidevs.createlogin.Login;

import com.holidevs.createlogin.AppUser.AppUser;
import com.holidevs.createlogin.AppUser.AppUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @CrossOrigin(value = "http://localhost:8100/login")
    @RequestMapping(path = "user")
    public AppUserDto login(@RequestBody AppUser user) {
            return loginService.loginUser(user);
    }
}
