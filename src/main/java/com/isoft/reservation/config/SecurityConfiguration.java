package com.isoft.reservation.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final String CUSTOMER_ROLE = "CUSTOMER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("12345").roles(ADMIN_ROLE).and()
                .withUser("user").password("123").roles(CUSTOMER_ROLE).and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests()
//                .mvcMatchers("/").authenticated()
////                .regexMatchers("/?(home(.html)?/?)?").authenticated()
////                .mvcMatchers("/h2-console/**").permitAll()
//                .and().formLogin().loginPage("/login").permitAll()
//                .defaultSuccessUrl("/home").failureUrl("/login?error=true")
//                .and().logout().permitAll()
//                .logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true);
//    }

}
