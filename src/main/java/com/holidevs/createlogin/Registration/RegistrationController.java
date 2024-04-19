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


    @RequestMapping(path = "user")
    public String register(@RequestBody AppUser user) {
        try {
            registrationService.register(user);
            return "Usuario creado correctamente";
        } catch (IllegalArgumentException e) {
            // Captura la excepción si algún campo está vacío o el correo electrónico ya está en uso
            return "Error al crear el usuario: " + e.getMessage();
        } catch (Exception e) {
            // Captura cualquier otra excepción inesperada
            return "Error desconocido al crear el usuario: " + e.getMessage();
        }
    }

    @RequestMapping(path = "admin")
    public AppUser registerAdmin(@RequestBody AppUser user){
        return registrationService.register(user);
    }
}
