package com.comumu.hmj.config;

import com.comumu.hmj.jwt.JwtAccessDeniedHandler;
import com.comumu.hmj.jwt.JwtAuthenticationEntry;
import com.comumu.hmj.jwt.JwtSecurityConfig;
import com.comumu.hmj.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //@PreAuthorize어노테이션 사용을 위해 선언
public class SecurityConfig {
    private final TokenProvider tokenProvider;

    //에러 반환 클래스들 선언후 주입
    private final JwtAuthenticationEntry jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(
            TokenProvider tokenProvider,
            JwtAuthenticationEntry jwtAuthenticationEntryPoint,
            JwtAccessDeniedHandler jwtAccessDeniedHandler
    ) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        // h2-console 하위 모든 요청들, 파비콘 관련 요청은 Spring Security 로직을 수행하지 않는다
//        return (web) -> web.ignoring().anyRequest();
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable);
//        http
//                .authorizeHttpRequests(
//                        authorize -> authorize
//                                .requestMatchers("/user/hello").permitAll()
//                                .requestMatchers("/auth/login").permitAll()
//                                .anyRequest().authenticated()
//                );
//        return http.build();
//    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin(formLogin -> formLogin.disable())
                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/users/mypage/**").authenticated()
                                .requestMatchers("/admin/**").hasRole("ADMIN"))
                // 예외 처리
                .exceptionHandling((exceptionHandling) ->
                        exceptionHandling.authenticationEntryPoint(jwtAuthenticationEntryPoint) //customEntryPoint
                                .accessDeniedHandler(jwtAccessDeniedHandler) // cutomAccessDeniedHandler
                );
        return http.build();
    }

}
