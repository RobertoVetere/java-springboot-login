package com.holidevs.createlogin.Login;

import com.holidevs.createlogin.AppUser.AppUser;
import com.holidevs.createlogin.AppUser.AppUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @CrossOrigin(value = "http://localhost:8100/")
    @RequestMapping(path = "user")
    public ResponseEntity<?> login(@RequestBody AppUser user) {
        try {
            AppUserDto authenticatedUser = loginService.loginUser(user);
            return ResponseEntity.ok(authenticatedUser);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al intentar iniciar sesión");
        }
    }
}
