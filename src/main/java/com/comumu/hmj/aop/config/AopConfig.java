package com.comumu.hmj.aop.config;

import com.comumu.hmj.aop.logtrace.asepct.LogTraceAspect;
import com.comumu.hmj.aop.logtrace.trace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }
}
