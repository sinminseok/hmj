package com.comumu.hmj.aop.logtrace.asepct;

import com.comumu.hmj.aop.logtrace.model.TraceStatus;
import com.comumu.hmj.aop.logtrace.trace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class LogTraceAspect {

    @Pointcut("execution(* com.comumu.hmj.*.controller.*.*(..))")
    public void controllerPointcut() {}

    @Pointcut("execution(* com.comumu.hmj.*.service.*.*(..))")
    public void servicePointcut() {}

    @Pointcut("execution(* com.comumu.hmj.*.repository.*.*(..))")
    public void repositoryPointcut() {}

    private final LogTrace logTrace;

    public LogTraceAspect(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    @Around("controllerPointcut() || servicePointcut() || repositoryPointcut()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        TraceStatus status = null;
        try {
            String message = joinPoint.getSignature().toShortString();
            status = logTrace.begin(message);
            Object result = joinPoint.proceed();
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e; }
    }
}
