package ait.cohort34.security.config;

import ait.cohort34.security.filter.TokenFilter;
import ait.cohort34.security.service.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    final private TokenFilter tokenFilter;
    public SecurityConfig(TokenFilter tokenFilter) {
        this.tokenFilter = tokenFilter;
    }
    @Bean
    @Primary
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(x->x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(x->x
                        .requestMatchers(HttpMethod.GET,"/account/user/{login}","/pet/found/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/auth/login","/auth/refresh","/account").permitAll()
                        .requestMatchers(HttpMethod.DELETE,"/pet/{id}","/account/user/{login}").hasRole("ADMIN")
                   //     .requestMatchers(HttpMethod.PUT,"/pet/update/{id}","/account/user/{login}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/account/user/{login}/role").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/account/users").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .addFilterAfter(tokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }





}
