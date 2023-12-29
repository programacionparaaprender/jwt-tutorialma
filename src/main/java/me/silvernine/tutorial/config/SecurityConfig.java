package me.silvernine.tutorial.config;

import me.silvernine.tutorial.jwt.JwtSecurityConfig;
import me.silvernine.tutorial.jwt.JwtAccessDeniedHandler;
import me.silvernine.tutorial.jwt.JwtAuthenticationEntryPoint;
import me.silvernine.tutorial.jwt.TokenProvider;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {
    private final TokenProvider tokenProvider;
    private final CorsFilter corsFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(
        TokenProvider tokenProvider,
        CorsFilter corsFilter,
        JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
        JwtAccessDeniedHandler jwtAccessDeniedHandler
    ) {
        this.tokenProvider = tokenProvider;
        this.corsFilter = corsFilter;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // tokenì�„ ì‚¬ìš©í•˜ëŠ” ë°©ì‹�ì�´ê¸° ë•Œë¬¸ì—� csrfë¥¼ disableí•©ë‹ˆë‹¤.
            .csrf(csrf -> csrf.disable())

            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
            .exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
            )

            .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                .antMatchers("/api/hello", "/api/authenticate", "/api/signup").permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll()
                .antMatchers("/v3/api-docs/", "/swagger-ui/**").permitAll()
                .antMatchers("/v3/api-docs/**").permitAll()
                .anyRequest().authenticated()
            )

            // ì„¸ì…˜ì�„ ì‚¬ìš©í•˜ì§€ ì•Šê¸° ë•Œë¬¸ì—� STATELESSë¡œ ì„¤ì •
            .sessionManagement(sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // enable h2-console
            .headers(headers ->
                headers.frameOptions(options ->
                    options.sameOrigin()
                )
            )

            .apply(new JwtSecurityConfig(tokenProvider));
        return http.build();
    }
}