package com.weatherinfo.weatherinfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/weather").authenticated()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/weather", true)
                )
                .logout(logout -> logout
                        .logoutSuccessUrl(
                                "https://dev-5zlc7l1aws2t5046.us.auth0.com/v2/logout" +
                                        "?client_id=NfseWd2ACs5mkcRvnohkKYZVty3hqwp2" +
                                        "&returnTo=http://localhost:8080"
                        )
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                );

        return http.build();
    }
}
