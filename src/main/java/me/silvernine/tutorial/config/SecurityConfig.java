package me.silvernine.tutorial.config;

import me.silvernine.tutorial.jwt.JwtSecurityConfig;
import me.silvernine.tutorial.dto.UserDto;
import me.silvernine.tutorial.dto.response.UserDtoResponse;
import me.silvernine.tutorial.jwt.JwtAccessDeniedHandler;
import me.silvernine.tutorial.jwt.JwtAuthenticationEntryPoint;
import me.silvernine.tutorial.jwt.TokenProvider;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
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
    	
    	/*
    	 * @GetMapping("/list")
    @GetMapping("/user")

    @GetMapping("/user/{username}")

    	 * */
    	
        http
            // tokenì�„ ì‚¬ìš©í•˜ëŠ” ë°©ì‹�ì�´ê¸° ë•Œë¬¸ì—� csrfë¥¼ disableí•©ë‹ˆë‹¤.
            .csrf(csrf -> csrf.disable())

            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
            .exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
            )

				
				  .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests //para corregir bloqueo en amazon 
				  .requestMatchers("/api/user/list", "/api/auth/user",
				  "/api/user/user/{username}", "/api/user/user/", "/api/user/user").permitAll()
				  .requestMatchers("/tipocambio/cambio/{monedaorigen}/{monedadestino}/{monto}",
				  "/tipocambio/cambio").permitAll() .requestMatchers("/api/menu/").permitAll()
				  
				  .requestMatchers("/api/user/hello", "/api/auth/token", "/api/auth/authenticate",
				  "/api/user/signup").permitAll()
				  .requestMatchers("/api/user/registrar","/api/user/registrar/",
				  "/api/user/registrar/**").permitAll()
				  .requestMatchers("/api/tarjeta","/api/tarjeta/","/api/tarjeta/**",
				  "/api/tarjeta/{id}").permitAll()
				  .requestMatchers(PathRequest.toH2Console()).permitAll()
				  .requestMatchers("/v3/api-docs/", "/swagger-ui/**").permitAll()
				  .requestMatchers("/v3/api-docs/**").permitAll() .anyRequest().authenticated() )
				 
            
				/*
				 * .authorizeHttpRequests(authorize -> authorize
				 * .requestMatchers("/api/user/list", "/api/auth/user",
				 * "/api/user/user/{username}", "/api/user/user/", "/api/user/user").permitAll()
				 * .requestMatchers("/tipocambio/cambio/{monedaorigen}/{monedadestino}/{monto}",
				 * "/tipocambio/cambio").permitAll() .requestMatchers("/api/menu/").permitAll()
				 * .requestMatchers("/api/user/hello", "/api/auth/token",
				 * "/api/auth/authenticate", "/api/user/signup").permitAll()
				 * .requestMatchers("/api/user/registrar","/api/user/registrar/",
				 * "/api/user/registrar/**").permitAll()
				 * .requestMatchers("/api/tarjeta","/api/tarjeta/","/api/tarjeta/**",
				 * "/api/tarjeta/{id}").permitAll()
				 * .requestMatchers(PathRequest.toH2Console()).permitAll()
				 * .requestMatchers("/v3/api-docs/", "/swagger-ui/**").permitAll()
				 * .requestMatchers("/v3/api-docs/**").permitAll() .anyRequest().authenticated()
				 * )
				 */


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