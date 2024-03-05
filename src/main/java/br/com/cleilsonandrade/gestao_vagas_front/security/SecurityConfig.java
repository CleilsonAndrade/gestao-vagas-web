package br.com.cleilsonandrade.gestao_vagas_front.security;

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
              .requestMatchers("/candidates/signIn").permitAll();
          auth.anyRequest().authenticated();
        })
        .formLogin(form -> form.loginPage("/candidates/login"));

    return httpSecurity.build();
  }
}
