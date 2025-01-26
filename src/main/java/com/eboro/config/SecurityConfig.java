package com.eboro.config;

import com.eboro.security.JpaUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JpaUserDetails userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/login", "/styles/**", "/js/**", "/plugins/**", "/images/**").permitAll() // Allow access to login and public pages without authentication
                .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                ); // Ensure all other pages require authentication
//        ).formLogin(form -> form.loginPage("/login").loginProcessingUrl("/user_authenticate") // Endpoint for form submission
//                .defaultSuccessUrl("/dashboard", true) // Redirect on successful login
//                .failureHandler(new CustomAuthenticationFailureHandler())// Redirect on failed logi// Custom login page
//                .permitAll() // Allow everyone to access the login page
//                .defaultSuccessUrl("/landing", true) // Redirect to /landing after successful login
//

//        .logout(logout -> logout.logoutUrl("/logout") // URL to trigger logout
//                .logoutSuccessUrl("/logout-success") // Redirect to this URL after successful logout
//                .invalidateHttpSession(true) // Invalidate session on logout
//                .deleteCookies("JSESSIONID") // Optionally delete session cookie
//                .permitAll() // Allow everyone to log out

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService); // Link your custom UserDetailsService
        authProvider.setPasswordEncoder(passwordEncoder());    // Use BCrypt for password hashing
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
