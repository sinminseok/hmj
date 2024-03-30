package com.comumu.hmj;

import com.comumu.hmj.aop.config.AopConfig;
import com.comumu.hmj.aop.logtrace.trace.LogTrace;
import com.comumu.hmj.aop.logtrace.trace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableAspectJAutoProxy
@Import(AopConfig.class)
@SpringBootApplication
public class HmjApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmjApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}

}
