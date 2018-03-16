package com.example.testweb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Roma Dziuba <rodzi@smile.fr>
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().getUserDetailsService()
                .createUser(User.withUsername("admin").password("admin").roles("USER").build());
        auth.build();
        super.configure(auth);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.formLogin().defaultSuccessUrl("/human/");
        http.antMatcher("/**");
        http.logout().permitAll();
        super.configure(http);
    }
    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("admin").password("{bcrypt}$2a$11$JJ6PBTiYhJ62zcdIbOE8I.zJgtThk15Y2AR55w4NfP29q1pUkLMkS").roles("ADMIN").build();//1seed1
        return new InMemoryUserDetailsManager(user);
    }

}
