package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class TestSecurityConfig {
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 🔐 Disable CSRF protection (normally needed for forms)
            .csrf(csrf -> csrf.disable())

            // ✅ Allow all requests without authentication
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            )

            // 🔒 Optional: enable basic HTTP auth (not required here)
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
