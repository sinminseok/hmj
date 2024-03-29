package com.comumu.hmj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HmjApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmjApplication.class, args);
	}

}
