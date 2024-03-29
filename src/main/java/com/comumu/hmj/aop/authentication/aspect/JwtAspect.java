package com.comumu.hmj.aop.authentication.aspect;

import com.comumu.hmj.account.filter.JwtAuthenticationFilter;
import com.comumu.hmj.user.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class JwtAspect {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Around("execution(* com.comumu.hmj..controller.*.*(..)) && args(request,..)")
    public Object aroundControllerMethod(ProceedingJoinPoint joinPoint, HttpServletRequest request) throws Throwable {
        log.info("ASPECT 실헹");
        // 메서드 실행 전에 수행할 작업
        Optional<User> user = jwtAuthenticationFilter.findByAccessToken(request);
        // 대상 메서드 실행
        Object result = joinPoint.proceed();
        // 메서드 실행 후에 수행할 작업
        return result;
    }
}
