package com.holidevs.createlogin.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService{

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Optional<AppUser> loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email);
    }

    public AppUser createAppUser(AppUser user) {
        // Verificar si alguno de los campos está vacío
        if (user.getName() == null || user.getUsername() == null || user.getEmail() == null || user.getPassword() == null || user.getAppUserRole() == null) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }

        // Verificar si el correo electrónico ya está en uso
        Optional<AppUser> existingUser = appUserRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("El correo electrónico ya está en uso");
        }

        // Codificar la contraseña y guardar el nuevo usuario
        AppUser newAppUser = new AppUser(
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getAppUserRole());
        String encodePassword = passwordEncoder.encode(newAppUser.getPassword());
        newAppUser.setPassword(encodePassword);
        appUserRepository.save(newAppUser);
        return newAppUser;
    }
}
