package com.isoft.reservation.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String ADMIN_ROLE = "ADMIN";
    private static final String CUSTOMER_ROLE = "CUSTOMER";

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Admin").password("12345").roles(CUSTOMER_ROLE).and()
                .withUser("Hossein").password("456").roles(ADMIN_ROLE).and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
