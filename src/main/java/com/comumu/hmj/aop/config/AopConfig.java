package com.comumu.hmj.aop.config;

import com.comumu.hmj.aop.logtrace.asepct.LogTraceAspect;
import com.comumu.hmj.aop.logtrace.trace.LogTrace;
import com.comumu.hmj.aop.logtrace.trace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect() {
        ThreadLocalLogTrace logTrace = new ThreadLocalLogTrace();
        return new LogTraceAspect(logTrace);
    }
}
