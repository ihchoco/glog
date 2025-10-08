package com.ihchoco.glog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class GlogApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GlogApplication.class, args);

		// # spring bean 조회
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		Arrays.stream(beanNames).forEach(System.out::println);
	}


}
