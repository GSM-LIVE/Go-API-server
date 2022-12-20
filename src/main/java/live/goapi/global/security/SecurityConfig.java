package live.goapi.global.security;

import live.goapi.global.filter.JwtRequestFilter;
import live.goapi.global.security.handler.CustomAccessDeniedHandler;
import live.goapi.global.security.handler.CustomAuthenticationEntryPointHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/email/**").permitAll()

                .antMatchers(HttpMethod.POST, "/club/**").hasAuthority("MEMBER")
                .antMatchers(HttpMethod.GET, "/club/**").hasAuthority("MEMBER")

                .antMatchers("/club/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.POST, "/student/**").hasAuthority("MEMBER")
                .antMatchers(HttpMethod.GET, "/student/**").hasAuthority("MEMBER")

                .antMatchers("/student/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.POST, "/teacher/**").hasAuthority("MEMBER")
                .antMatchers(HttpMethod.GET, "/teacher/**").hasAuthority("MEMBER")

                .antMatchers("/teacher/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.POST,"/api-key/**").hasAuthority("MEMBER")
                .antMatchers("/api-key/**").hasAuthority("ADMIN")

                .anyRequest().authenticated();
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .exceptionHandling()
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                .authenticationEntryPoint(new CustomAuthenticationEntryPointHandler());
        http
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
