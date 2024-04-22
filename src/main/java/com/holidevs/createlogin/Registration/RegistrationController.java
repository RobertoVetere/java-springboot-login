package com.holidevs.createlogin.Registration;
import com.holidevs.createlogin.AppUser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @CrossOrigin(value = "http://localhost:8100/")
    @RequestMapping(path = "user")
    public ResponseEntity<?> register(@RequestBody AppUser user) {
        try {
            registrationService.registerUser(user);
            return ResponseEntity.ok().body("Usuario creado correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error al crear el usuario: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error desconocido al crear el usuario: " + e.getMessage());
        }
    }

    @RequestMapping(path = "admin")
    public AppUser registerAdmin(@RequestBody AppUser user){
        return registrationService.registerAdmin(user);
    }
}
