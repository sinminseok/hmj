package com.comumu.hmj.aop.config;

import com.comumu.hmj.account.filter.JwtAuthenticationFilter;
import com.comumu.hmj.account.service.JwtService;
import com.comumu.hmj.aop.authentication.aspect.JwtAspect;
import com.comumu.hmj.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public JwtAspect jwtAspect() {
        return new JwtAspect(new JwtAuthenticationFilter(jwtService, userRepository));
    }
}
