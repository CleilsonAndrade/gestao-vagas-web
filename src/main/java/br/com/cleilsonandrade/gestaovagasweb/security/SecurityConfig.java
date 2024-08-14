package br.com.cleilsonandrade.gestaovagasweb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests(
        auth -> {
          auth.requestMatchers("/candidates/login").permitAll()
              .requestMatchers("/candidates/signin").permitAll()
              .requestMatchers("/candidates/create").permitAll()
              .requestMatchers("/companies/login").permitAll()
              .requestMatchers("/companies/signin").permitAll()
              .requestMatchers("/companies/create").permitAll();
          auth.anyRequest().authenticated();
        })
        .formLogin(form -> form.loginPage("/candidates/login"));

    return httpSecurity.build();
  }
}
