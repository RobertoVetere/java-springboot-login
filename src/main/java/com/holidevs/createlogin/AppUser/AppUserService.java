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

    public AppUser createAppUser(AppUser user){
        AppUser newAppUser = new AppUser(
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                AppUserRole.USER);
        String encodePassword = passwordEncoder.encode(newAppUser.getPassword());
        newAppUser.setPassword(encodePassword);
        appUserRepository.save(newAppUser);
        return newAppUser;
    }
}
