package com.holidevs.createlogin.Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalAuthentication
public class SecurityConfiguration {

    @Bean
    PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConf) throws Exception {
        return authConf.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();

       //httpSecurity.authorizeHttpRequests().anyRequest().permitAll();
        httpSecurity.authorizeHttpRequests()

                .requestMatchers(HttpMethod.GET, "/account-holder/balance/{id}").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/account-holder/transfer").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/account-holder/savings-balance/{id}").hasRole("USER")
                .requestMatchers(HttpMethod.PATCH, "/account-holder/deposit/{id}").hasRole("USER")




                ////////////////////////////

              //  .requestMatchers(HttpMethod.GET, "/account-holder/transfer").hasRole("AccountHolder")
                 //.requestMatchers(HttpMethod.GET, "/user-admin-area**").hasRole("ADMIN")
              //  .requestMatchers(HttpMethod.GET, "/user-details").hasAnyRole("ADMIN", "USER")

                .anyRequest().permitAll();

        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }

}
